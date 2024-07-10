package com.example.devicetrack.ui.grupos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.devicetrack.R
import com.example.devicetrack.data.network.Service
import com.example.devicetrack.data.DispositivosRepository
import com.example.devicetrack.ui.viewmodel.GruposViewModel
import com.example.devicetrack.ui.viewmodel.GruposViewModelFactory

class GruposFragment : Fragment() {

    private val service = Service()
    private val repository = DispositivosRepository(service)
    private val viewModel: GruposViewModel by viewModels {
        GruposViewModelFactory(repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Aquí puedes inicializar otras cosas si es necesario
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_grupos, container, false)

        // Observa los cambios en los datos del ViewModel
        viewModel.grupos.observe(viewLifecycleOwner, Observer { grupos ->
            // Actualiza la UI con la lista de grupos
        })

        // Llama a fetchGrupos con el idDispositivo necesario
        val idDispositivo = "someId"  // reemplaza con el idDispositivo adecuado
        viewModel.fetchGrupos(idDispositivo)

        return view
    }

    companion object {
        fun newInstance() = GruposFragment()
    }
}
