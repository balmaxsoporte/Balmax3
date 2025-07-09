package com.example.patiobalmax.util

import android.content.Context
import java.io.InputStream

object FileUtils {
    fun readRawFile(context: Context, resourceId: Int): String {
        return context.resources.openRawResource(resourceId).bufferedReader().use { it.readText() }
    }
}
