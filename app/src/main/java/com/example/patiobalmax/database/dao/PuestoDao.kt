package com.example.patiobalmax.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.patiobalmax.database.entity.Puesto

@Dao
interface PuestoDao {
    @Query("SELECT * FROM puesto WHERE patioId = :patioId")
    suspend fun getPuestosByPatio(patioId: Int): List<Puesto>
}
