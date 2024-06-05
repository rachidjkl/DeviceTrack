package com.example.devicetrack.data

import com.example.devicetrack.data.model.Dispositivo
import com.example.devicetrack.data.network.Service

class DispositivosRepository {

    private val api = Service()

    suspend fun getAllDispositivos():List<Dispositivo>{
        return api.getDispositivos()
    }

    suspend fun getAllDispositivosFav():List<Dispositivo>{
        return api.getDispositivosFav()
    }
}