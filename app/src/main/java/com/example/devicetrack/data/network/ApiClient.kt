package com.example.devicetrack.data.network

import com.example.devicetrack.data.model.Dispositivo
import com.example.devicetrack.data.model.Usuario
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiClient {
    @GET("/dispositivos/usuario/{usuario}")
    suspend fun getAllDispositivos(@Path("usuario")  usuario:String): Response<List<Dispositivo>>

    @GET("/dispositivos/favoritos/1")
    suspend fun getAllDispositivosFav(): Response<List<Dispositivo>>


    @GET("/usuario/{emailOrPhone}/{password}")
    suspend fun getUsuarioLogin(@Path("emailOrPhone") emailOrPhone:String, @Path("password") password:String): Response<List<Usuario>>

    @POST("/dispositivos/favoritos")
    suspend fun PostAllDispositivosFav(): Response<List<Dispositivo>>
}