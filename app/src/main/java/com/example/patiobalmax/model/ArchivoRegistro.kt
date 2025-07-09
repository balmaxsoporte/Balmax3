package com.example.patiobalmax.model

data class ArchivoRegistro(
    val patio: Int,
    val puesto: Int,
    val detalleLugar1: String,
    val patenteLugar1: String,
    val detalleLugar2: String?,
    val patenteLugar2: String?,
    val nombreArrendatario: String?
)
