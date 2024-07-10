package com.example.devicetrack.ui.listaDispositivos

import Dispositivo
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.devicetrack.R
import com.example.devicetrack.data.network.Service
import com.example.devicetrack.databinding.FragmentListaDispositivoBinding
import com.example.devicetrack.ui.home.AdapterResumenDeEquipo

class listaDispositivo : Fragment() {

    private var _binding: FragmentListaDispositivoBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ListaDispositivoViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListaDispositivoBinding.inflate(inflater, container, false)

        // ViewModelFactory para inyectar Service en ListaDispositivoViewModel
        val viewModelFactory = ListaDispositivoViewModelFactory(Service())

        // Inicializar el ViewModel utilizando viewModels y el ViewModelFactory personalizado
        viewModel = ViewModelProvider(this, viewModelFactory).get(ListaDispositivoViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.onCreate(requireContext())
        viewModel.dispositivoModel.observe(viewLifecycleOwner, Observer { listDispositivos ->
            // Configurar el adaptador solo si la lista de dispositivos no es nula
            listDispositivos?.let {
                val adapter = AdapterResumenDeEquipo(requireContext(), it, object : AdapterResumenDeEquipo.OnItemClickListener {
                    override fun onItemClick(dispositivo: Dispositivo) {
                        // Implementa la lógica para manejar el clic en el dispositivo aquí
                    }

                    override fun onItemLongClick(dispositivo: Dispositivo) {
                        // Implementa la lógica para manejar el clic largo en el dispositivo aquí
                    }
                })
                binding.rvResumenEquipos.layoutManager = GridLayoutManager(requireContext(), 2)
                binding.rvResumenEquipos.adapter = adapter
            }
        })

        binding.btnBack.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }

        binding.dispoAdd.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_lista_dispositivos_to_navigation_anyadir_dispositivo)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
