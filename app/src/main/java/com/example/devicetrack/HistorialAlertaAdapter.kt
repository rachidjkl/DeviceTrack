package com.example.devicetrack

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class HistorialAlerta(val prioridad: String, val descripcion: String, val fecha: String)

class HistorialAlertaAdapter(private val historial: List<HistorialAlerta>) :
    RecyclerView.Adapter<HistorialAlertaAdapter.HistorialAlertaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistorialAlertaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_historial_alerta, parent, false)
        return HistorialAlertaViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistorialAlertaViewHolder, position: Int) {
        holder.bind(historial[position])
    }

    override fun getItemCount(): Int = historial.size

    class HistorialAlertaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val prioridad: TextView = itemView.findViewById(R.id.tv_prioridad)
        private val descripcion: TextView = itemView.findViewById(R.id.tv_descripcion)
        private val fecha: TextView = itemView.findViewById(R.id.tv_fecha)

        fun bind(historialAlerta: HistorialAlerta) {
            prioridad.text = historialAlerta.prioridad
            descripcion.text = historialAlerta.descripcion
            fecha.text = historialAlerta.fecha
        }
    }
}
