package com.example.ejercicio_api_nasa.client

import com.example.ejercicio_api_nasa.service.TerrenosService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClienteDeRetrofit {

    companion object{
        private val url = "https://android-kotlin-fun-mars-server.appspot.com/"

        fun obtenCliente(): TerrenosService{
            val retrofit = Retrofit.Builder().baseUrl(url).addConverterFactory(
                GsonConverterFactory.create()).build()
            return retrofit.create(TerrenosService::class.java)
        }
    }
}