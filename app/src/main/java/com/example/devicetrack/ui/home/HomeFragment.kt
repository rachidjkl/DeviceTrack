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
import androidx.recyclerview.widget.LinearLayoutManager
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
            val adapter = AdapterResumenDeEquipo(requireContext(),listDispositivos!!)
            binding.rvResumenEquipos.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            binding.rvResumenEquipos.adapter = adapter
        })
        homeViewModel.isLoading.observe(viewLifecycleOwner, Observer {
            binding.progressBar.isVisible = it
        })

        homeViewModel.dispositivoFavModel.observe(viewLifecycleOwner, Observer { listDispositivos ->
            if (listDispositivos.isNullOrEmpty()){
                binding.noFav.isVisible=true
                binding.rvEqiposFav.isVisible=false

            }else{
                binding.noFav.isVisible=false
                val adapter = AdapterResumenDeEquipo(requireContext(),listDispositivos!!)
                binding.rvEqiposFav.isVisible=true
                binding.rvEqiposFav.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                binding.rvEqiposFav.adapter = adapter
            }
        })

        //binding.verMasEquipos.click


        val root: View = binding.root


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}