package com.example.devicetrack

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.devicetrack.databinding.DialogCleaningCompletedBinding
import com.example.devicetrack.databinding.DialogCleaningConfirmationBinding
import com.example.devicetrack.databinding.FragmentDetalleEquipoBinding

class DetalleEquipoFragment : Fragment() {

    private var _binding: FragmentDetalleEquipoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetalleEquipoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRealizarLimpieza.setOnClickListener {
            showCleaningConfirmationDialog()
        }
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
            // Aquí puedes manejar el comentario ingresado
            dialog.dismiss()
        }

        dialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
