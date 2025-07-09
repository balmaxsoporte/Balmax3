package com.example.patiobalmax.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "patios")
data class Patio(
    @PrimaryKey val numeroPatio: Int,
    val descripcion: String = "Patio $numeroPatio"
)
