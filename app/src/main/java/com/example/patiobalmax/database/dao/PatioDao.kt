package com.example.patiobalmax.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.patiobalmax.database.entity.Patio

@Dao
interface PatioDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(patio: Patio)

    @Query("SELECT * FROM patios ORDER BY numeroPatio ASC")
    suspend fun getAllPatios(): List<Patio>
}
