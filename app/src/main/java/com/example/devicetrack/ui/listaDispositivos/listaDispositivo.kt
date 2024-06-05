package com.example.devicetrack.ui.listaDispositivos

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.devicetrack.R
import com.example.devicetrack.databinding.FragmentHomeBinding
import com.example.devicetrack.databinding.FragmentListaDispositivoBinding
import com.example.devicetrack.ui.home.AdapterResumenDeEquipo

class listaDispositivo : Fragment() {

    private var _binding: FragmentListaDispositivoBinding? = null

    private val binding get() = _binding!!

    private val viewModel: ListaDispositivoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListaDispositivoBinding.inflate(inflater, container, false)

        viewModel.onCreate()
        viewModel.dispositivoModel.observe(viewLifecycleOwner, Observer { listDispositivos ->
            val adapter = AdapterListaDispositivo(requireContext(),listDispositivos!!)
            binding.rvResumenEquipos.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            binding.rvResumenEquipos.adapter = adapter
        })
        viewModel.isLoading.observe(viewLifecycleOwner, Observer {
            //binding.progressBar.isVisible = it
        })
        return inflater.inflate(R.layout.fragment_lista_dispositivo, container, false)
    }
}