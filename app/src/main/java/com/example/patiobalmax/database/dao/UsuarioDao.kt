package com.example.patiobalmax.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.patiobalmax.database.entity.Usuario

@Dao
interface UsuarioDao {
    @Query("SELECT * FROM usuario WHERE nombre = :nombre LIMIT 1")
    suspend fun getUsuario(nombre: String): Usuario?

    @Insert
    suspend fun insert(usuario: Usuario)
}
