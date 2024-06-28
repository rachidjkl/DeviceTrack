package com.example.devicetrack.ui.listaDispositivos.detallesEditarDispisitivo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.devicetrack.R
import com.example.devicetrack.data.model.Dispositivo
import com.example.devicetrack.databinding.FragmentDetallesEditarDispositivosBinding
import com.example.devicetrack.databinding.FragmentHomeBinding


class DetallesEditarDispositivos : Fragment() {

    private var _binding: FragmentDetallesEditarDispositivosBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //arguments?.let {
          //  val dispositivo = it.getParcelable<Dispositivo>("dispositivo")
            //binding.editTextNumeroSerie.setText(dispositivo?.numero_serie)
        //}
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}