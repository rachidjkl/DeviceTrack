// DetallesEditarDispositivos.kt
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
import android.app.AlertDialog
import android.text.InputType
import android.widget.EditText
import android.widget.Toast
import com.example.devicetrack.data.network.Service

class DetallesEditarDispositivos : Fragment(), AdapterDetallesEditarGrupos.OnItemClickListener {

    private val dispositivoRepo by lazy { DispositivosRepository(Service()) }
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
            val dispositivoId = it.getInt("dispositivoId")
            lifecycleScope.launch {
                val dispositivo = dispositivoRepo.getDispositivoNumSerie(dispositivoId.toString())
                dispositivo?.let {
                    binding.editTextNumeroSerie.setText(it.numero_serie)
                    binding.editTextNombre.setText(it.nombre)
                    val color = ContextCompat.getColor(requireContext(), R.color.gris)
                    if (it.conexion == 0) {
                        binding.icConectado.setColorFilter(color)
                    }

                    val grupos = dispositivoRepo.getAllGrupDispositivos(it.Id_dispositivo.toString())
                    if (grupos.isEmpty()) {
                        binding.rvGrupos.isVisible = false
                    } else {
                        val adapter = AdapterDetallesEditarGrupos(requireContext(), grupos, this@DetallesEditarDispositivos)
                        binding.rvGrupos.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                        binding.rvGrupos.adapter = adapter
                    }
                }
            }
        }

        binding.verMasEquipos.setOnClickListener {
            showConnectionMethodDialog()
        }
    }

    private fun showConnectionMethodDialog() {
        val options = arrayOf("Vía QR (Cámara)", "Vía Código")
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Método de Conexión")
        builder.setItems(options) { _, which ->
            when (which) {
                0 -> Toast.makeText(requireContext(), "Vía QR selected", Toast.LENGTH_SHORT).show()
                1 -> showInputCodeDialog()
            }
        }
        builder.show()
    }

    private fun showInputCodeDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Introduce código")

        val input = EditText(requireContext())
        input.inputType = InputType.TYPE_CLASS_TEXT
        builder.setView(input)

        builder.setPositiveButton("Conectar") { _, _ ->
            val code = input.text.toString()
            Toast.makeText(requireContext(), "Código ingresado: $code", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("Cancelar") { dialog, _ -> dialog.cancel() }

        builder.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(grupo: Grupo) {
        val bundle = Bundle().apply {
            putParcelable("dispositivo", grupo)
        }
        findNavController().navigate(R.id.action_navigation_home_to_navigation_detalles_editar_equipo, bundle)
    }
}
