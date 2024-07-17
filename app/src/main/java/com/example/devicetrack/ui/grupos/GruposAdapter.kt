package com.example.devicetrack.ui.grupos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.devicetrack.R
import com.example.devicetrack.data.model.Grupo

class GruposAdapter : RecyclerView.Adapter<GruposAdapter.GrupoViewHolder>() {

    private var grupos: List<Grupo> = emptyList()

    fun submitList(grupos: List<Grupo>) {
        this.grupos = grupos
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GrupoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_grupo, parent, false)
        return GrupoViewHolder(view)
    }

    override fun onBindViewHolder(holder: GrupoViewHolder, position: Int) {
        val grupo = grupos[position]
        holder.bind(grupo)
    }

    override fun getItemCount(): Int {
        return grupos.size
    }

    class GrupoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewNombre: TextView = itemView.findViewById(R.id.nombreGrupo)

        fun bind(grupo: Grupo) {
            textViewNombre.text = grupo.nombre
        }
    }
}
