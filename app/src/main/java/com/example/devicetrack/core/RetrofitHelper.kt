package com.example.devicetrack.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://hawk-proper-rhino.ngrok-free.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}