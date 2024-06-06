package com.example.devicetrack.ui.listaDispositivos

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.devicetrack.R
import com.example.devicetrack.databinding.FragmentHomeBinding
import com.example.devicetrack.databinding.FragmentListaDispositivoBinding
import com.example.devicetrack.ui.home.AdapterResumenDeEquipo
import com.example.devicetrack.ui.home.HomeViewModel

class listaDispositivo : Fragment() {

    private var _binding: FragmentListaDispositivoBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel = ViewModelProvider(this).get(ListaDispositivoViewModel::class.java)
        _binding = FragmentListaDispositivoBinding.inflate(inflater, container, false)

        viewModel.onCreate()
        viewModel.dispositivoModel.observe(viewLifecycleOwner, Observer { listDispositivos ->
            val adapter = AdapterListaDispositivo(requireContext(),listDispositivos!!)
            binding.rvResumenEquipos.layoutManager = GridLayoutManager(requireContext(), 2)
            binding.rvResumenEquipos.adapter = adapter
        })
        viewModel.isLoading.observe(viewLifecycleOwner, Observer {
            //binding.progressBar.isVisible = it
        })
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}