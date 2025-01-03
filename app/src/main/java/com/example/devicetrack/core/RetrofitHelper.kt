package com.example.devicetrack.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://10.0.0.4:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}