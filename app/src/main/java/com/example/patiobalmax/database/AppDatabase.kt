package com.example.patiobalmax.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.patiobalmax.database.dao.PuestoDao
import com.example.patiobalmax.database.dao.UsuarioDao
import com.example.patiobalmax.database.entity.Puesto
import com.example.patiobalmax.database.entity.Usuario

@Database(entities = [Usuario::class, Puesto::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    // Acceso a los DAOs
    abstract fun usuarioDao(): UsuarioDao
    abstract fun puestoDao(): PuestoDao

    companion object {
        // Nombre de la base de datos
        private const val DATABASE_NAME = "patiobalmax.db"

        // Singleton para evitar múltiples instancias de la BD
        @Volatile
        private var INSTANCE: AppDatabase? = null

        // Obtiene la instancia única de la base de datos
        fun getDatabase(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { instance ->
                    INSTANCE = instance
                }
            }

        // Construye la base de datos usando Room
        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(
                appContext.applicationContext,
                AppDatabase::class.java,
                DATABASE_NAME
            ).build()
    }
}
