package com.example.devicetrack.ui.listaDispositivos

import Dispositivo
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

class AdapterListaDispositivo(private val context: Context, private val dispositivoList: List<Dispositivo>) : RecyclerView.Adapter<AdapterListaDispositivo.HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.card_dispositivo_grande, parent, false)
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
        private val btnFav: ImageView = itemView.findViewById(R.id.icFavorito)


        fun bind(dispositivo: Dispositivo) {
            tituloTextView.text = dispositivo.nombre
            if (dispositivo.favorito == 0){
                btnFav.setImageResource(R.drawable.favorite_border)
            }else{
                btnFav.setImageResource(R.drawable.favorite)
            }

        }
    }
}