package com.example.devicetrack.data.network

import com.example.devicetrack.data.model.Dispositivo
import com.example.devicetrack.data.model.Usuario
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiClient {
    @GET("/dispositivos")
    suspend fun getAllDispositivos(): Response<List<Dispositivo>>

    @GET("/dispositivos/favoritos/1")
    suspend fun getAllDispositivosFav(): Response<List<Dispositivo>>

    @POST("/dispositivos/favoritos")
    suspend fun PostAllDispositivosFav(): Response<List<Dispositivo>>

    @GET("/usuario")
    suspend fun getUserProfile(): Response<Usuario>

}