package com.example.devicetrack.data

import Dispositivo
import com.example.devicetrack.data.model.Grupo
import com.example.devicetrack.data.model.Usuario_dispositivo
import com.example.devicetrack.data.network.Service

class DispositivosRepository(service: Service) {

    private val api = Service()

    suspend fun getAllDispositivos(idUser:String):List<Dispositivo>{
        return api.getDispositivos(idUser)
    }

    suspend fun getAllDispositivosFav(idUser : String):List<Dispositivo>{
        return api.getDispositivosFav(idUser)
    }

    suspend fun getAllGrupDispositivos(idDispositivo:String):List<Grupo>{
        return api.getAllGrupDispositivos(idDispositivo)
    }

    suspend fun postDispositivo(dispositivo: Dispositivo){
        api.postDispositivo(dispositivo)
    }

    suspend fun getDispositivoNumSerie(numSerie: String) : Dispositivo {
        return api.getDispositivoNumSerie(numSerie)
    }

    suspend fun createUsuario_dispositivo(usuario_dispositivo: Usuario_dispositivo){
        api.createUsuario_dispositivo(usuario_dispositivo)
    }
    suspend fun getDispositivoById(id: Int): Dispositivo? {
        return api.getDispositivoById(id)
    }


}