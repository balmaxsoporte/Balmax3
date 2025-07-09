package com.example.patiobalmax.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.patiobalmax.database.entity.Puesto

@Dao
interface PuestoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(puesto: Puesto)

    @Update
    suspend fun update(puesto: Puesto)

    @Query("SELECT * FROM puestos WHERE numeroPatio = :patioNumero ORDER BY numeroPuesto ASC")
    suspend fun getPuestosPorPatio(patioNumero: Int): List<Puesto>

    @Query("UPDATE puestos SET esArrendatario = :esArrendatario, nombreArrendatario = :nombreArrendatario WHERE id = :puestoId")
    suspend fun actualizarArrendatario(puestoId: Int, esArrendatario: Boolean, nombreArrendatario: String?)

    @Query("UPDATE puestos SET esParticular = :esParticular WHERE id = :puestoId")
    suspend fun actualizarParticular(puestoId: Int, esParticular: Boolean)

    @Query("UPDATE puestos SET tieneTicket = :tieneTicket WHERE id = :puestoId")
    suspend fun actualizarTicket(puestoId: Int, tieneTicket: Boolean)
}
