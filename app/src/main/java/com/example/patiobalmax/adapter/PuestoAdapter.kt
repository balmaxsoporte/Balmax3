package com.example.patiobalmax.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.patiobalmax.R
import com.example.patiobalmax.model.EstadoPuesto

class PuestoAdapter(private val puestos: List<EstadoPuesto>) :
    RecyclerView.Adapter<PuestoAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_puesto, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val puesto = puestos[position]
        holder.itemView.findViewById<TextView>(R.id.textPuesto).text = "Puesto ${puesto.numero}"
        holder.itemView.setBackgroundColor(
            when (puesto.estado) {
                "Arrendatario" -> R.color.green
                "Particular" -> R.color.blue
                else -> R.color.white
            }
        )
    }

    override fun getItemCount(): Int = puestos.size
}
