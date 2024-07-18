// DetalleEquipoFragment.kt
package com.example.devicetrack.ui.detalleequipo

import Dispositivo
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.devicetrack.data.DispositivosRepository
import com.example.devicetrack.data.network.Service
import com.example.devicetrack.databinding.DialogCleaningCompletedBinding
import com.example.devicetrack.databinding.DialogCleaningConfirmationBinding
import com.example.devicetrack.databinding.FragmentDetalleEquipoBinding
import kotlinx.coroutines.launch

class DetalleEquipoFragment : Fragment() {

    private var _binding: FragmentDetalleEquipoBinding? = null
    private val binding get() = _binding!!
    private val dispositivoRepo by lazy { DispositivosRepository(Service()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetalleEquipoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {

            val dispositivo = it.getParcelable<Dispositivo>("dispositivo")
            binding.tvNombreEquipo.text = dispositivo?.nombre

        }

        val dispositivoId = arguments?.getInt("dispositivoId") ?: return

        lifecycleScope.launch {
            val dispositivo = dispositivoRepo.getDispositivoById(dispositivoId)
            dispositivo?.let { showDispositivoDetails(it) }
        }

        binding.btnRealizarLimpieza.setOnClickListener {
            showCleaningConfirmationDialog()
        }
    }

    private fun showDispositivoDetails(dispositivo: Dispositivo) {
        binding.tvNombreEquipo.text = dispositivo.nombre
        binding.tvStatus.text = if (dispositivo.conexion == 1) "🟢" else "🔴"

    }

    private fun showCleaningConfirmationDialog() {
        val dialogBinding = DialogCleaningConfirmationBinding.inflate(layoutInflater)
        val dialog = AlertDialog.Builder(requireContext())
            .setView(dialogBinding.root)
            .create()

        dialogBinding.btnYes.setOnClickListener {
            dialog.dismiss()
            showCleaningCompletedDialog()
        }

        dialogBinding.btnNo.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun showCleaningCompletedDialog() {
        val dialogBinding = DialogCleaningCompletedBinding.inflate(layoutInflater)
        val dialog = AlertDialog.Builder(requireContext())
            .setView(dialogBinding.root)
            .create()

        dialogBinding.btnConfirm.setOnClickListener {
            val comment = dialogBinding.etComment.text.toString()
            dialog.dismiss()
        }

        dialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
