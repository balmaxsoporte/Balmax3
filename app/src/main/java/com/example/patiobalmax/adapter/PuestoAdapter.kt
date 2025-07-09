package com.example.patiobalmax.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.patiobalmax.database.entity.Puesto
import com.example.patiobalmax.databinding.ItemPuestoBinding

class PuestoAdapter(
    private val puestos: List<Puesto>,
    private val onItemClick: (Puesto) -> Unit
) : RecyclerView.Adapter<PuestoAdapter.PuestoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PuestoViewHolder {
        val binding = ItemPuestoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PuestoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PuestoViewHolder, position: Int) {
        val puesto = puestos[position]
        holder.bind(puesto)
        holder.itemView.setOnClickListener { onItemClick(puesto) }
    }

    override fun getItemCount(): Int = puestos.size

    class PuestoViewHolder(private val binding: ItemPuestoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(puesto: Puesto) {
            binding.tvNumeroPuesto.text = "Puesto ${puesto.numeroPuesto}"
            binding.tvEstadoPuesto.text = when {
                puesto.esArrendatario -> "Arrendatario"
                puesto.esParticular -> "Particular"
                else -> "Libre"
            }

            // Icono según tipo de vehículo
            binding.ivIconoVehiculo.setImageResource(
                if (puesto.tipoVehiculoLugar1.contains("Camión")) com.example.patiobalmax.R.drawable.icono_camion
                else com.example.patiobalmax.R.drawable.icono_auto
            )

            // Color de fondo según estado
            binding.root.setBackgroundColor(
                when {
                    puesto.esArrendatario -> binding.root.context.getColor(android.R.color.holo_green_light)
                    puesto.esParticular -> binding.root.context.getColor(android.R.color.holo_blue_light)
                    else -> binding.root.context.getColor(android.R.color.white)
                }
            )

            // Mostrar nombre del arrendatario si corresponde
            binding.tvNombreArrendatario.text = puesto.nombreArrendatario ?: ""

            // Mostrar iconos según permisos o estado
            binding.ivTicket.visibility = if (puesto.tieneTicket) View.VISIBLE else View.GONE
            binding.ivEditar.visibility = if (puesto.esArrendatario || puesto.esParticular) View.VISIBLE else View.GONE
        }
    }
}
