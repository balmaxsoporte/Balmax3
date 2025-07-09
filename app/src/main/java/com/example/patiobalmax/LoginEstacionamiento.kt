package com.example.patiobalmax

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.patiobalmax.databinding.ActivityLoginEstacionamientoBinding
import com.example.patiobalmax.database.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginEstacionamiento : AppCompatActivity() {

    private lateinit var binding: ActivityLoginEstacionamientoBinding
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginEstacionamientoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AppDatabase.getInstance(this)

        // Inicializar usuarios por defecto si no existen
        CoroutineScope(Dispatchers.IO).launch {
            val usuarioAdmin = db.usuarioDao().getUsuarioPorNombre("admin")
            val usuario1 = db.usuarioDao().getUsuarioPorNombre("user1")
            val usuario2 = db.usuarioDao().getUsuarioPorNombre("user2")

            if (usuarioAdmin == null) {
                db.usuarioDao().insert(
                    Usuario(nombreUsuario = "admin", contrasena = "admin", permisos = "Administrador")
                )
            }
            if (usuario1 == null) {
                db.usuarioDao().insert(
                    Usuario(nombreUsuario = "user1", contrasena = "12345", permisos = "Editar Patentes")
                )
            }
            if (usuario2 == null) {
                db.usuarioDao().insert(
                    Usuario(nombreUsuario = "user2", contrasena = "12345", permisos = "Validar Patios y Puestos")
                )
            }
        }

        binding.btnIniciarSesion.setOnClickListener {
            val nombreUsuario = binding.etUsuario.text.toString()
            val contrasena = binding.etContrasena.text.toString()

            CoroutineScope(Dispatchers.IO).launch {
                val usuario = db.usuarioDao().getUsuarioPorNombre(nombreUsuario)
                runOnUiThread {
                    if (usuario != null && usuario.contrasena == contrasena) {
                        val intent = Intent(this@LoginEstacionamiento, MapaEstacionamiento::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this@LoginEstacionamiento, R.string.mensaje_error_credenciales, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}
