package com.example.devicetrack.data.network

import com.example.devicetrack.data.model.Dispositivo
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {
    @GET("/dispositivos")
    suspend fun getAllDispositivos(): Response<List<Dispositivo>>

    @GET("/dispositivos/favoritos/1")
    suspend fun getAllDispositivosFav(): Response<List<Dispositivo>>
}