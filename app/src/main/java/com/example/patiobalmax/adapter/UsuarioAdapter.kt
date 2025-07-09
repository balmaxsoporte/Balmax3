package com.example.patiobalmax.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.patiobalmax.database.entity.Usuario
import com.example.patiobalmax.databinding.ItemUsuarioBinding

class UsuarioAdapter(
    private val usuarios: List<Usuario>,
    private val onItemClick: (Usuario) -> Unit
) : RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val binding = ItemUsuarioBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UsuarioViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val usuario = usuarios[position]
        holder.bind(usuario)
        holder.itemView.setOnClickListener { onItemClick(usuario) }
    }

    override fun getItemCount(): Int = usuarios.size

    class UsuarioViewHolder(private val binding: ItemUsuarioBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(usuario: Usuario) {
            binding.tvNombreUsuario.text = usuario.nombreUsuario
            binding.tvPermisos.text = usuario.permisos
        }
    }
}
