package com.example.devicetrack.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.devicetrack.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        homeViewModel.onCreate()
        homeViewModel.dispositivoModel.observe(viewLifecycleOwner, Observer { listDispositivos ->
            val adapter = AdapterResumenDeEquipo(listDispositivos!!)
            val gridLayoutManager = GridLayoutManager(requireContext(), 2) // 2 es el número de columnas en la cuadrícula
            binding.rvResumenEquipos.layoutManager = gridLayoutManager
            binding.rvResumenEquipos.adapter = adapter
        })
        homeViewModel.isLoading.observe(viewLifecycleOwner, Observer {
            binding.progressBar.isVisible = it
        })


        val root: View = binding.root


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}