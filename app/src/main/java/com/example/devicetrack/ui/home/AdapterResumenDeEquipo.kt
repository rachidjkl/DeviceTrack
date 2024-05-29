package com.example.devicetrack.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.devicetrack.R
import com.example.devicetrack.data.model.Dispositivos

class AdapterResumenDeEquipo(private val context: Context, private val dispositivoList: List<Dispositivos>) : RecyclerView.Adapter<AdapterResumenDeEquipo.HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.card_dispositivo, parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val dispositivo = dispositivoList[position]
        holder.bind(dispositivo)
    }

    override fun getItemCount(): Int {
        return dispositivoList.size
    }

    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tituloTextView: TextView = itemView.findViewById(R.id.tituloCard)


        fun bind(dispositivo: Dispositivos) {
            tituloTextView.text = dispositivo.nombre

        }
    }
}
