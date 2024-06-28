package com.example.devicetrack.ui.listaDispositivos.detallesEditarDispisitivo

import Dispositivo
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.devicetrack.R
import com.example.devicetrack.databinding.FragmentDetallesEditarDispositivosBinding

class DetallesEditarDispositivos : Fragment() {

    private var _binding: FragmentDetallesEditarDispositivosBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetallesEditarDispositivosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val dispositivo = it.getParcelable<Dispositivo>("dispositivo")
            binding.editTextNumeroSerie.setText(dispositivo?.numero_serie)
            binding.editTextNombre.setText(dispositivo?.nombre)
            val color = ContextCompat.getColor(requireContext(), R.color.gris)
            if(dispositivo?.conexion == 0){
                binding.icConectado.setColorFilter(color)
            }


        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
