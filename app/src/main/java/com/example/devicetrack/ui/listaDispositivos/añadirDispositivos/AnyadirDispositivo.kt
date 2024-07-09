package com.example.devicetrack.ui.listaDispositivos.añadirDispositivos

import Dispositivo
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.devicetrack.data.DispositivosRepository
import com.example.devicetrack.data.model.Usuario_dispositivo
import com.example.devicetrack.databinding.FragmentAnyadirDispositivoBinding
import kotlinx.coroutines.launch


class AnyadirDispositivo : Fragment() {

    private var _binding: FragmentAnyadirDispositivoBinding? = null
    private val repoDispositivo = DispositivosRepository()

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
        binding.btnGuardar.setOnClickListener{
            val dispositivo = Dispositivo(
                Id_dispositivo = 0,
                numero_serie = binding.editTextNumeroSerie.text.toString(),
                nombre = binding.editTextNombre.text.toString(),
                imagen = null,
                favorito = 0,
                conexion = 0,
                codigo_conexion = 1234
            )
            lifecycleScope.launch {
                repoDispositivo.postDispositivo(dispositivo)
                val sharedPreferences: SharedPreferences? = context?.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
                val idUser = sharedPreferences?.getString("idUser", null).toString()
                val ultimoDispo = repoDispositivo.getDispositivoNumSerie(binding.editTextNumeroSerie.text.toString())
                val usuario_dispositivo = Usuario_dispositivo(
                    usuario = idUser.toInt(),
                    dispositivo =ultimoDispo.Id_dispositivo,
                    favorito = 0,
                    conexion = 0
                )
                Log.d("Auth", "usuario_dispositivo: $usuario_dispositivo")
                repoDispositivo.createUsuario_dispositivo(usuario_dispositivo)
                Toast.makeText(requireContext(), "Dispositivo añadido", Toast.LENGTH_SHORT).show()
                requireActivity().supportFragmentManager.popBackStack()
            }

        }
        return binding.root
    }
}