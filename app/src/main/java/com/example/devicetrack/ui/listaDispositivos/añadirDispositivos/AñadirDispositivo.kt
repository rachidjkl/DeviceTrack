package com.example.devicetrack.ui.listaDispositivos.añadirDispositivos

import Dispositivo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.devicetrack.R
import com.example.devicetrack.ui.grupos.GruposAdapter

class AñadirDispositivo : Fragment() {

    private lateinit var etNombre: EditText
    private lateinit var etNumeroSerie: EditText
    private lateinit var btnGuardar: Button
    private lateinit var btnSeleccionarImagen: Button
    private lateinit var ivSeleccionImagen: ImageView
    private lateinit var rvGrupos: RecyclerView

    private val viewModel: AñadirDispositivoViewModel by viewModels()

    class AñadirDispositivo : Fragment() {

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            val view = inflater.inflate(R.layout.fragment_anyadir_dispositivo, container, false)

            // Acceder al botón
            val btnAddGrupo = view.findViewById<Button>(R.id.btn_add)

            // Configurar OnClickListener para el botón
            btnAddGrupo.setOnClickListener {
                // Aquí puedes manejar lo que sucede cuando se hace clic en el botón
                Toast.makeText(requireContext(), "Botón Añadir Grupo clickeado", Toast.LENGTH_SHORT).show()
            }

            return view
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializar vistas
        etNombre = view.findViewById(R.id.editTextNombre)
        etNumeroSerie = view.findViewById(R.id.editTextNumeroSerie)
        btnGuardar = view.findViewById(R.id.btnGuardar)
        btnSeleccionarImagen = view.findViewById(R.id.seleccionaImg)
        rvGrupos = view.findViewById(R.id.rvGrupos)

        // Configurar RecyclerView de Grupos
        rvGrupos.layoutManager = LinearLayoutManager(requireContext())
        val gruposAdapter = GruposAdapter()
        rvGrupos.adapter = gruposAdapter

        // Observar cambios en la lista de grupos
        viewModel.listaGrupos.observe(viewLifecycleOwner, { grupos ->
            gruposAdapter.submitList(grupos)
        })

        // Observar el resultado de guardar el dispositivo
        viewModel.guardarDispositivoResult.observe(viewLifecycleOwner, { success ->
            if (success) {
                Toast.makeText(requireContext(), "Dispositivo guardado correctamente", Toast.LENGTH_SHORT).show()
                etNombre.text.clear()
                etNumeroSerie.text.clear()
            } else {
                Toast.makeText(requireContext(), "Error al guardar el dispositivo", Toast.LENGTH_SHORT).show()
            }
        })

        // Listener del botón Guardar
        btnGuardar.setOnClickListener {
            val nombre = etNombre.text.toString()
            val numeroSerie = etNumeroSerie.text.toString()

            // Validar campos
            if (nombre.isEmpty() || numeroSerie.isEmpty()) {
                Toast.makeText(requireContext(), "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Crear dispositivo
            val dispositivo = Dispositivo(
                Id_dispositivo = 0,  // assuming a new device starts with ID 0 or change as needed
                nombre = nombre,
                numero_serie = numeroSerie,
                imagen = "",  // default empty image or change as needed
                favorito = 0,  // default not favorite
                conexion = 0,  // default not connected
                codigo_conexion = 0  // default no connection code
            )

            // Guardar dispositivo en ViewModel
            viewModel.guardarDispositivo(dispositivo)
        }

        // Obtener grupos para un dispositivo en específico (idDispositivo debe ser reemplazado con el ID adecuado)
        viewModel.obtenerGrupos("idDispositivo")
    }
}
