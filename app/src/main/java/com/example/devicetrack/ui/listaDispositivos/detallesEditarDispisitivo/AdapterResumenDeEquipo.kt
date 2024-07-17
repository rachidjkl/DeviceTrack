package com.example.devicetrack.ui.listaDispositivos.detallesEditarDispisitivo;


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.devicetrack.R
import com.example.devicetrack.data.model.Grupo

class AdapterDetallesEditarGrupos(
        private val context: Context,
        private val grupoList: List<Grupo>,
        private val itemClickListener: AdapterDetallesEditarGrupos.OnItemClickListener
) : RecyclerView.Adapter<AdapterDetallesEditarGrupos.DetallesEditarViewHolder>() {

        interface OnItemClickListener {
                fun onItemClick(grupo: Grupo)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetallesEditarViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_grupo, parent, false)
        return DetallesEditarViewHolder(view)
        }

        override fun onBindViewHolder(holder: DetallesEditarViewHolder, position: Int) {
                val grupo = grupoList[position]
                holder.bind(grupo, itemClickListener)
        }

        override fun getItemCount(): Int {
                return grupoList.size
        }

        inner class DetallesEditarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
                private val icGrupo: TextView = itemView.findViewById(R.id.icGrupo)
                private val nombreGrupo: TextView = itemView.findViewById(R.id.nombreGrupo)


                fun bind(grupo: Grupo, clickListener: AdapterDetallesEditarGrupos.OnItemClickListener) {
                        nombreGrupo.text = grupo.nombre
                        icGrupo.text = grupo.nombre.toUpperCase().take(1)

                        itemView.setOnClickListener {
                                clickListener.onItemClick(grupo)
                        }

                }

        }
}

