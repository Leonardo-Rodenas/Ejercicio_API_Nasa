package com.example.ejercicio_api_nasa.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.ejercicio_api_nasa.client.ClienteDeRetrofit
import com.example.ejercicio_api_nasa.dao.TerrenosDao
import com.example.ejercicio_api_nasa.model.TerrenosModelItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TerrenosRepositorio(private val terrenosDao: TerrenosDao) {

    private val service = ClienteDeRetrofit.obtenCliente()
    val miLiveData = terrenosDao.obtenerTodosLosTerrenosDeLaBD()

    fun obtenDataDelServer() {
        val call = service.obtenerTerrenos()
        call.enqueue(object : Callback<List<TerrenosModelItem>> {
            override fun onResponse(
                call: Call<List<TerrenosModelItem>>,
                response: Response<List<TerrenosModelItem>>
            ) {
                CoroutineScope(Dispatchers.IO).launch {
                    response.body()?.let {
                        Log.v("logenrepo", response.body().toString())
                        terrenosDao.insertarTodosLosTerrenos(it)
                    }
                }
            }

            override fun onFailure(call: Call<List<TerrenosModelItem>>, t: Throwable) {
                call.cancel()
            }

        })
    }

    fun exponeDatosDelBaseDeDatos(): LiveData<List<TerrenosModelItem>> {
        return terrenosDao.obtenerTodosLosTerrenosDeLaBD()
    }
}