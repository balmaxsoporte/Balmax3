package com.example.patiobalmax.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "puestos")
data class Puesto(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val numeroPuesto: Int,
    val numeroPatio: Int,

    var tipoVehiculoLugar1: String = "",
    var patenteLugar1: String = "",
    var tipoVehiculoLugar2: String = "",
    var patenteLugar2: String = "",

    var esArrendatario: Boolean = false,
    var esParticular: Boolean = false,
    var nombreArrendatario: String? = null,
    var tieneTicket: Boolean = false
)
