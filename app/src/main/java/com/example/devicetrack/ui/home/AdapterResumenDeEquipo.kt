package com.example.devicetrack.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.devicetrack.R
import com.example.devicetrack.data.model.Dispositivos

class AdapterResumenDeEquipo(private val dispositivoList: List<Dispositivos>) : RecyclerView.Adapter<AdapterResumenDeEquipo.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_dispositivo, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val dispositivo = dispositivoList[position]
        holder.titleTextView.text = dispositivo.nombre
    }

    override fun getItemCount() = dispositivoList.size

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.titulo)
    }
}
