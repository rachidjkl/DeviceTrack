package com.example.devicetrack.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.devicetrack.R
import com.example.devicetrack.data.model.Dispositivo

class AdapterResumenDeEquipo(
    private val context: Context,
    private val dispositivoList: List<Dispositivo>,
    private val itemClickListener: OnItemClickListener // Añade el parámetro de la interfaz
) : RecyclerView.Adapter<AdapterResumenDeEquipo.HomeViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(dispositivo: Dispositivo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.card_dispositivo, parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val dispositivo = dispositivoList[position]
        holder.bind(dispositivo, itemClickListener) // Pasa el listener al método bind
    }

    override fun getItemCount(): Int {
        return dispositivoList.size
    }

    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tituloTextView: TextView = itemView.findViewById(R.id.tituloCard)

        fun bind(dispositivo: Dispositivo, clickListener: OnItemClickListener) {
            tituloTextView.text = dispositivo.nombre

            // Establece el OnClickListener en el itemView
            itemView.setOnClickListener {
                clickListener.onItemClick(dispositivo)
            }
        }
    }
}
