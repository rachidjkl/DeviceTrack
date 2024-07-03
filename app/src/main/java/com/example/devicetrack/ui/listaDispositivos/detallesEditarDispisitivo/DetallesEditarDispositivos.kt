package com.example.devicetrack.ui.listaDispositivos.detallesEditarDispisitivo

import Dispositivo
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.devicetrack.R
import com.example.devicetrack.data.DispositivosRepository
import com.example.devicetrack.data.model.Grupo
import com.example.devicetrack.databinding.FragmentDetallesEditarDispositivosBinding
import kotlinx.coroutines.launch

class DetallesEditarDispositivos : Fragment() , AdapterDetallesEditarGrupos.OnItemClickListener{



    val dispositivoRepo = DispositivosRepository()


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
            lifecycleScope.launch {
                val grupos = dispositivoRepo.getAllGrupDispositivos(dispositivo?.Id_dispositivo.toString())
                if(grupos.isEmpty()){
                    binding.rvGrupos.isVisible= false
                }else{
                    val adapter = AdapterDetallesEditarGrupos(requireContext(),grupos!!, this@DetallesEditarDispositivos)
                    binding.rvGrupos.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                    binding.rvGrupos.adapter = adapter
                }
            }




        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(grupo: Grupo) {
        val bundle = Bundle().apply {
            putParcelable("dispositivo", grupo)
        }
        Log.d("Auth", "User: $bundle")
        findNavController().navigate(R.id.action_navigation_home_to_navigation_detalles_editar_equipo, bundle)

    }
}
