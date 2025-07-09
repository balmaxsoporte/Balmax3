package com.example.patiobalmax

import android.app.Application
import com.example.patiobalmax.database.AppDatabase

class App : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
}
