package com.example.patiobalmax.util

object Constants {
    const val PREFS_NAME = "patiobalmax_prefs"
    const val KEY_ARCHIVOS_SUBIDOS = "archivos_subidos"
    const val MAX_ARCHIVOS_GUARDADOS = 5
}

sealed class TipoArchivo(val nombre: String) {
    object Arrendatarios : TipoArchivo("arrendatarios.txt")
    object Particulares : TipoArchivo("particulares.txt")
}
