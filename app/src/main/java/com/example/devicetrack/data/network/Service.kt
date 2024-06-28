package com.example.devicetrack.data.network

import Dispositivo
import com.example.devicetrack.core.RetrofitHelper
import com.example.devicetrack.data.model.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Service {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getDispositivos(idUser:String): List<Dispositivo> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ApiClient::class.java).getAllDispositivos(idUser)
            response.body() ?: emptyList()
        }
    }

    suspend fun getDispositivosFav(): List<Dispositivo> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ApiClient::class.java).getAllDispositivosFav()
            response.body() ?: emptyList()
        }
    }

    suspend fun getUsuarioLogin(emailOrPhone: String, password: String): List<Usuario> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ApiClient::class.java).getUsuarioLogin(emailOrPhone, password)
            response.body() ?: emptyList()
        }
    }
}