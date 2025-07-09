package com.example.patiobalmax.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Usuario::class, Patio::class, Puesto::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDao
    abstract fun patioDao(): PatioDao
    abstract fun puestoDao(): PuestoDao
}
