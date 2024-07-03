package com.example.devicetrack.ui.home

import Dispositivo
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.devicetrack.R
import com.example.devicetrack.databinding.FragmentHomeBinding

class HomeFragment : Fragment() , AdapterResumenDeEquipo.OnItemClickListener{

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onItemClick(dispositivo: Dispositivo) {
        val bundle = Bundle().apply {
           putParcelable("dispositivo", dispositivo)
        }
        Log.d("Auth", "User: $bundle")
        findNavController().navigate(R.id.action_navigation_home_to_navigation_detalles_editar_equipo, bundle)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        homeViewModel.onCreate(requireContext())
        homeViewModel.dispositivoModel.observe(viewLifecycleOwner, Observer { listDispositivos ->
            val adapter = AdapterResumenDeEquipo(requireContext(),listDispositivos!!, this)
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
                val adapter = AdapterResumenDeEquipo(requireContext(),listDispositivos!!, this)
                binding.rvEqiposFav.isVisible=true
                binding.rvEqiposFav.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                binding.rvEqiposFav.adapter = adapter
            }
        })

        binding.verMasEquipos.setOnClickListener{
            findNavController().navigate(R.id.action_navigation_home_to_navigation_lista_dispositivos)
        }
        binding.verMasEquipos2.setOnClickListener{
            findNavController().navigate(R.id.action_navigation_home_to_navigation_lista_dispositivos)
        }




        //val root: View = binding.root


        binding.BtnDetails.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}