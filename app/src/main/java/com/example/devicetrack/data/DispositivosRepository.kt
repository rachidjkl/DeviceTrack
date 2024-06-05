package com.example.devicetrack.data

import com.example.devicetrack.data.model.Dispositivos
import com.example.devicetrack.data.network.Service

class DispositivosRepository {

    private val api = Service()

    suspend fun getAllDispositivos():List<Dispositivos>{
        return api.getDispositivos()
    }

    suspend fun getAllDispositivosFav():List<Dispositivos>{
        return api.getDispositivosFav()
    }
}