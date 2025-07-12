package com.example.patiobalmax.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.patiobalmax.R
import com.example.patiobalmax.model.Usuario

class UsuarioAdapter(private val usuarios: List<Usuario>) :
    RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder>() {

    private var onItemClickListener: ((Usuario) -> Unit)? = null

    inner class UsuarioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreUsuario: TextView = itemView.findViewById(R.id.nombreUsuario)
        val textPermisos: TextView = itemView.findViewById(R.id.textPermisos)
        val iconoEditar: ImageView = itemView.findViewById(R.id.iconoEditar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_usuario, parent, false)
        return UsuarioViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val usuario = usuarios[position]
        holder.nombreUsuario.text = usuario.nombre
        holder.textPermisos.text = usuario.permisos

        holder.itemView.setOnClickListener {
            onItemClickListener?.invoke(usuario)
        }
    }

    override fun getItemCount(): Int = usuarios.size

    fun setOnItemClickListener(listener: (Usuario) -> Unit) {
        onItemClickListener = listener
    }
}
