package com.example.devicetrack.data

import Dispositivo
import com.example.devicetrack.data.model.Grupo
import com.example.devicetrack.data.network.Service

class DispositivosRepository {

    private val api = Service()

    suspend fun getAllDispositivos(idUser:String):List<Dispositivo>{
        return api.getDispositivos(idUser)
    }

    suspend fun getAllDispositivosFav():List<Dispositivo>{
        return api.getDispositivosFav()
    }

    suspend fun getAllGrupDispositivos(idDispositivo:String):List<Grupo>{
        return api.getAllGrupDispositivos(idDispositivo)
    }
}