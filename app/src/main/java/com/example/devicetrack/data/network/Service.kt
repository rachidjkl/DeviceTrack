package com.example.devicetrack.data.network

import Dispositivo
import com.example.devicetrack.core.RetrofitHelper
import com.example.devicetrack.data.model.Grupo
import com.example.devicetrack.data.model.Usuario
import com.example.devicetrack.data.model.Usuario_dispositivo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Service {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getDispositivos(idUser: String): List<Dispositivo> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ApiClient::class.java).getAllDispositivos(idUser)
            response.body() ?: emptyList()
        }
    }

    suspend fun getDispositivosFav(idUser: String): List<Dispositivo> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ApiClient::class.java).getAllDispositivosFav(idUser)
            response.body() ?: emptyList()
        }
    }

    suspend fun getUsuarioLogin(emailOrPhone: String, password: String): List<Usuario> {
        return withContext(Dispatchers.IO) {
            val response =
                retrofit.create(ApiClient::class.java).getUsuarioLogin(emailOrPhone, password)
            response.body() ?: emptyList()
        }
    }

    suspend fun getAllGrupDispositivos(idDispositivo: String): List<Grupo> {
        return withContext(Dispatchers.IO) {
            val response =
                retrofit.create(ApiClient::class.java).getAllGrupDispositivos(idDispositivo)
            response.body() ?: emptyList()
        }
    }

    suspend fun postDispositivo(Dispositivo: Dispositivo) {
        withContext(Dispatchers.IO) {
            retrofit.create(ApiClient::class.java).createDispositivo(Dispositivo)
        }
    }

    suspend fun createUsuario_dispositivo(Usuario_dispositivo: Usuario_dispositivo) {
        withContext(Dispatchers.IO) {
            retrofit.create(ApiClient::class.java).createUsuario_dispositivo(Usuario_dispositivo)
        }
    }

    suspend fun getDispositivoNumSerie(numSerie: String): Dispositivo {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ApiClient::class.java).getDispositivoNumSerie(numSerie)
            response.body()!!
        }
    }
    suspend fun getDispositivoById(id: Int): Dispositivo? {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ApiClient::class.java).getDispositivoById(id)
            response.body()
        }
    }
}

