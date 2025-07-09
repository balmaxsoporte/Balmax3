package com.example.patiobalmax.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.patiobalmax.R
import com.example.patiobalmax.model.Usuario

class UsuarioAdapter(private val usuarios: List<Usuario>) :
    RecyclerView.Adapter<UsuarioAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_usuario, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val usuario = usuarios[position]
        holder.itemView.findViewById<TextView>(R.id.nombreUsuario).text = usuario.nombre
    }

    override fun getItemCount(): Int = usuarios.size
}
