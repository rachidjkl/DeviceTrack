package com.example.devicetrack

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class HistorialLimpieza(val descripcion: String, val fecha: String)

class HistorialLimpiezaAdapter(private val historial: List<HistorialLimpieza>) :
    RecyclerView.Adapter<HistorialLimpiezaAdapter.HistorialLimpiezaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistorialLimpiezaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_historial_limpieza, parent, false)
        return HistorialLimpiezaViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistorialLimpiezaViewHolder, position: Int) {
        holder.bind(historial[position])
    }

    override fun getItemCount(): Int = historial.size

    class HistorialLimpiezaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val descripcion: TextView = itemView.findViewById(R.id.tv_descripcion)
        private val fecha: TextView = itemView.findViewById(R.id.tv_fecha)

        fun bind(historialLimpieza: HistorialLimpieza) {
            descripcion.text = historialLimpieza.descripcion
            fecha.text = historialLimpieza.fecha
        }
    }
}
