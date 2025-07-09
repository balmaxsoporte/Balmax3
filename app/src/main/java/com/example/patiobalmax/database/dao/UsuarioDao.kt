package com.example.patiobalmax.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.patiobalmax.database.entity.Usuario

@Dao
interface UsuarioDao {

    @Query("SELECT * FROM usuarios WHERE nombreUsuario = :nombreUsuario LIMIT 1")
    suspend fun getUsuarioPorNombre(nombreUsuario: String): Usuario?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(usuario: Usuario)

    @Query("SELECT * FROM usuarios")
    suspend fun getAllUsuarios(): List<Usuario>

    @Query("DELETE FROM usuarios WHERE nombreUsuario != 'admin'")
    suspend fun eliminarUsuariosExceptoAdmin()

    @Query("UPDATE usuarios SET contrasena = :nuevaContrasena, permisos = :nuevosPermisos WHERE nombreUsuario = :nombreUsuario")
    suspend fun actualizarUsuario(nombreUsuario: String, nuevaContrasena: String, nuevosPermisos: String)
}
