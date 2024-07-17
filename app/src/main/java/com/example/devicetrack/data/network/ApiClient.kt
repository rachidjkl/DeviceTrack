package com.example.devicetrack.data.network

import Dispositivo
import com.example.devicetrack.data.model.Grupo
import com.example.devicetrack.data.model.Usuario
import com.example.devicetrack.data.model.Usuario_dispositivo
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiClient {
    @GET("/dispositivos/usuario/{usuario}")
    suspend fun getAllDispositivos(@Path("usuario")  usuario:String): Response<List<Dispositivo>>

    @GET("/dispositivos/favoritos/{usuario}")
    suspend fun getAllDispositivosFav(@Path("usuario")  usuario:String): Response<List<Dispositivo>>


    @GET("/usuario/{emailOrPhone}/{password}")
    suspend fun getUsuarioLogin(@Path("emailOrPhone") emailOrPhone:String, @Path("password") password:String): Response<List<Usuario>>

    @POST("/dispositivos/favoritos")
    suspend fun PostAllDispositivosFav(): Response<List<Dispositivo>>


    @GET("/grupo_disp/{id_dispositivo}")
    suspend fun getAllGrupDispositivos(@Path("id_dispositivo")  id_dispositivo:String): Response<List<Grupo>>

    @POST("/usuarios")
    suspend fun createUser(@Body usuario: Usuario): Usuario

    @POST("/dispositivos")
    suspend fun createDispositivo(@Body dispositivo: Dispositivo): Dispositivo

    @POST("/usuario_dispositivo")
    suspend fun createUsuario_dispositivo(@Body usuario_dispositivo: Usuario_dispositivo): Usuario_dispositivo

    @GET("/dispositivo/{num_serie}")
    suspend fun getDispositivoNumSerie(@Path("num_serie") num_serie:String ): Response<Dispositivo>
    @GET("/dispositivo/{id}")
    suspend fun getDispositivoById(@Path("id") id: Int): Response<Dispositivo>

}
