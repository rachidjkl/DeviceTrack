package com.example.devicetrack.data

import com.example.devicetrack.data.model.Usuario
import com.example.devicetrack.data.network.Service

class UsuariosRepositorio {
    private val api = Service()


    suspend fun getUsuarioLogin(emailOrPhone: String, password: String):List<Usuario>
    {
        return api.getUsuarioLogin(emailOrPhone, password)
    }
}