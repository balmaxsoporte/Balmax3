package com.example.patiobalmax.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.patiobalmax.R
import com.example.patiobalmax.model.EstadoPuesto
import com.example.patiobalmax.util.Constants
import com.example.patiobalmax.ui.NavigationManager

class PuestoAdapter(private val puestos: List<EstadoPuesto>) :
    RecyclerView.Adapter<PuestoAdapter.ViewHolder>() {

    private var onItemClickListener: ((EstadoPuesto) -> Unit)? = null

    fun setOnItemClickListener(listener: (EstadoPuesto) -> Unit) {
        onItemClickListener = listener
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textPuesto: TextView = itemView.findViewById(R.id.textPuesto)
        val textEstado: TextView = itemView.findViewById(R.id.textEstado)
        val textArrendatario: TextView = itemView.findViewById(R.id.textArrendatario)
        val iconoVehiculo: ImageView = itemView.findViewById(R.id.iconoVehiculo)
        val iconoAccion: ImageView = itemView.findViewById(R.id.iconoAccion)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_puesto, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val puesto = puestos[position]

        holder.textPuesto.text = "Puesto ${puesto.numero}"
        holder.textEstado.text = when (puesto.estado) {
            "Arrendatario" -> "Ocupado - Arrendatario"
            "Particular" -> "Ocupado - Particular"
            else -> "Libre"
        }

        holder.textArrendatario.text = when (puesto.estado) {
            "Arrendatario" -> "ING"
            "Particular" -> ""
            else -> ""
        }

        holder.iconoVehiculo.setImageResource(
            when (puesto.tipoLugar1) {
                "Auto", "Camioneta", "Van" -> R.drawable.icono_auto
                "Camion", "Camion 3/4", "Maquinaria Pesada" -> R.drawable.icono_camion
                else -> R.drawable.icono_ticket
            }
        )

        holder.itemView.setBackgroundColor(
            when (puesto.estado) {
                "Arrendatario" -> R.color.green
                "Particular" -> R.color.blue
                else -> R.color.white
            }
        )

        holder.itemView.setOnClickListener {
            onItemClickListener?.invoke(puesto)
        }
    }

    override fun getItemCount(): Int = puestos.size
}
