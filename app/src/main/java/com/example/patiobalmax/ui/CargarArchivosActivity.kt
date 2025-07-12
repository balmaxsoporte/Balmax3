package com.example.patiobalmax.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.patiobalmax.R
import com.example.patiobalmax.database.AppDatabase
import com.example.patiobalmax.database.entity.Usuario
import com.example.patiobalmax.util.Constants
import kotlinx.android.synthetic.main.activity_cargar_archivos.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.text.SimpleDateFormat
import java.util.*

class CargarArchivosActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase

    // Para seleccionar archivos desde almacenamiento
    private val seleccionarArchivoLauncher = registerForActivityResult(
        ActivityResultContracts.OpenDocument()
    ) { uri: Uri? ->
        if (uri != null) {
            leerArchivoYActualizarBD(uri)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cargar_archivos)

        // Inicializar base de datos
        database = AppDatabase.getDatabase(this)

        // Recibir datos del usuario logueado
        val usuarioActual = intent.getStringExtra(Constants.EXTRA_USUARIO) ?: "Invitado"
        val permisosUsuario = intent.getStringExtra(Constants.EXTRA_PERMISOS) ?: ""

        setupBotones(usuarioActual, permisosUsuario)
    }

    private fun setupBotones(usuario: String, permisos: String) {
        when (permisos) {
            "Administrador" -> {
                btnSeleccionarArrendatarios.setOnClickListener {
                    seleccionarArchivo("arrendatarios")
                }
                btnSeleccionarParticulares.setOnClickListener {
                    seleccionarArchivo("particulares")
                }
            }
            else -> {
                btnSeleccionarArrendatarios.isEnabled = false
                btnSeleccionarParticulares.isEnabled = false
                Toast.makeText(this, "Solo el administrador puede cargar archivos", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun seleccionarArchivo(tipo: String) {
        seleccionarArchivoLauncher.launch(arrayOf("text/*"))
    }

    private fun leerArchivoYActualizarBD(uri: Uri) {
        val contentResolver = contentResolver
        val inputStream = contentResolver.openInputStream(uri)
        val fileName = getFileNameFromUri(uri)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val lineas = inputStream?.bufferedReader()?.readLines()

                withContext(Dispatchers.Main) {
                    if (!lineas.isNullOrEmpty()) {
                        for (linea in lineas) {
                            val datos = linea.split(",").map { it.trim() }

                            if (datos.size >= 7 && datos[0].startsWith("Patio")) {
                                val patio = datos[0]
                                val puesto = datos[1]
                                val lugar1 = datos[2]
                                val patente1 = datos[3]
                                val lugar2 = datos[4]
                                val patente2 = datos[5]
                                val arrendatario = datos[6]

                                // Guardar en base de datos
                                val estadoPuesto = EstadoPuesto(
                                    numero = puesto.filter { it.isDigit() }.toIntOrNull() ?: 1,
                                    tipoLugar1 = lugar1,
                                    patenteLugar1 = patente1.takeIf { it.isNotEmpty() },
                                    tipoLugar2 = lugar2.takeIf { it.isNotEmpty() },
                                    patenteLugar2 = patente2.takeIf { it.isNotEmpty() },
                                    estado = if (lugar1.contains("Libre") || patente1.isEmpty()) "Libre" else "Arrendatario"
                                )

                                // Aquí puedes insertar en la base de datos
                                // database.puestoDao().insert(estadoPuesto)

                                // Mostrar mensaje de confirmación
                                textMensajeResultado.text = "Archivo cargado: $fileName"
                                Toast.makeText(this@CargarArchivosActivity, "Datos cargados correctamente", Toast.LENGTH_SHORT).show()
                            } else {
                                mostrarError("Formato de archivo incorrecto")
                            }
                        }
                    } else {
                        mostrarError("El archivo está vacío")
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    mostrarError("Error al leer el archivo")
                }
            }
        }
    }

    private fun getFileNameFromUri(uri: Uri): String {
        var nombreArchivo = "archivo.txt"

        contentResolver.query(uri, null, null, null, null)?.use { cursor ->
            val nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
            if (nameIndex > -1) {
                cursor.moveToFirst()
                nombreArchivo = cursor.getString(nameIndex)
            }
        }

        return nombreArchivo
    }

    private fun mostrarError(mensaje: String) {
        textMensajeResultado.text = mensaje
        textMensajeResultado.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark))
    }

    private fun mostrarConfirmacion(mensaje: String) {
        textMensajeResultado.text = mensaje
        textMensajeResultado.setTextColor(ContextCompat.getColor(this, android.R.color.holo_green_dark))
    }

    private fun limpiarEstado() {
        textMensajeResultado.text = ""
    }
}
