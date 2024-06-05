package com.example.devicetrack.data.network

import com.example.devicetrack.core.RetrofitHelper
import com.example.devicetrack.data.model.Dispositivos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Service {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getDispositivos(): List<Dispositivos> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ApiClient::class.java).getAllDispositivos()
            response.body() ?: emptyList()
        }
    }

    suspend fun getDispositivosFav(): List<Dispositivos> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ApiClient::class.java).getAllDispositivosFav()
            response.body() ?: emptyList()
        }
    }
}