package com.example.ejercicio_api_nasa.service

import com.example.ejercicio_api_nasa.model.TerrenosModelItem
import retrofit2.Call
import retrofit2.http.GET

interface TerrenosService {

    @GET("realestate/")
    fun obtenerTerrenos(): Call<List<TerrenosModelItem>>


}