// build.gradle.kts (Project-level)
plugins {
    id("com.android.application") version "8.11.0" apply false
    id("org.jetbrains.kotlin.android") version "2.0.21" apply false
}

repositories {
    google() // Importante: Este es el repositorio oficial de Google
    mavenCentral()
}
