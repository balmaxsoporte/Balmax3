# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /usr/lib/android-sdk/tools/proguard/proguard-android-optimize.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.kts.

# Room database
-keep class androidx.room.RoomDatabase
-keep class com.example.patiobalmax.database.AppDatabase

# Keep DAOs and Entities
-keep interface com.example.patiobalmax.database.dao.* { *; }
-keep class com.example.patiobalmax.database.entity.* { *; }

# Kotlin coroutines
-if @kotlinx.coroutines.ExperimentalCoroutinesApi class **
-keep class kotlinx.coroutines.*

# Kotlinx serialization
-if @kotlinx.serialization.Serializable class **
-keep class kotlinx.serialization.*

# Keep model classes
-keep class com.example.patiobalmax.model.** { *; }

# Keep adapters for RecyclerView
-keep class com.example.patiobalmax.adapter.** { *; }

# Keep util classes
-keep class com.example.patiobalmax.util.Constants { *; }
-keep class com.example.patiobalmax.util.FileUtils { *; }

# Keep fragment dialogs
-keep class com.example.patiobalmax.AgregarUsuarioDialogFragment
-keep class com.example.patiobalmax.EditarUsuarioDialogFragment

# Keep resources used in code
-keepclassmembers class com.example.patiobalmax.R$* {
    public static <fields>;
}
