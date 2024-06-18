package com.example.devicetrack

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HistorialLimpiezaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_historial_limpieza, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_historial_limpieza)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = HistorialLimpiezaAdapter(getHistorialLimpieza())
    }

    private fun getHistorialLimpieza(): List<HistorialLimpieza> {
        return listOf(
            HistorialLimpieza("Última Limpieza", "12-10-2021"),
            HistorialLimpieza("Última Limpieza", "12-10-2021"),
            HistorialLimpieza("Última Limpieza", "12-10-2021"),
            HistorialLimpieza("Última Limpieza", "12-10-2021")
        )
    }
}
