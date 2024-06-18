package com.example.devicetrack

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HistorialAlertaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_historial_alerta, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_historial_alerta)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = HistorialAlertaAdapter(getHistorialAlertas())
    }

    private fun getHistorialAlertas(): List<HistorialAlerta> {
        // Simula obtener datos, aquí deberías implementar tu lógica para obtener los datos reales
        return listOf(
            HistorialAlerta("Prioridad Alta (Alerta)", "No tiene tinta", "20/04/2024"),
            HistorialAlerta("Prioridad Media (Alerta)", "No queda papel", "20/04/2024"),
            HistorialAlerta("Actualización exitosa (Información general)", "", "20/04/2024")
        )
    }
}
