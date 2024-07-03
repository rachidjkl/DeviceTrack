package com.example.devicetrack.ui.listaDispositivos.añadirDispositivos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.devicetrack.R
import com.example.devicetrack.databinding.FragmentAnyadirDispositivoBinding
import com.example.devicetrack.databinding.FragmentListaDispositivoBinding


class AnyadirDispositivo : Fragment() {

    private var _binding: FragmentAnyadirDispositivoBinding? = null

    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAnyadirDispositivoBinding.inflate(inflater, container, false)
        binding.btnBack.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
        return binding.root
    }
}