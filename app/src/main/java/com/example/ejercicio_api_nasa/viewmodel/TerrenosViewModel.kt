package com.example.ejercicio_api_nasa.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ejercicio_api_nasa.database.TerrenosDataBase
import com.example.ejercicio_api_nasa.model.TerrenosModelItem
import com.example.ejercicio_api_nasa.repository.TerrenosRepositorio

class TerrenosViewModel(application: Application) : AndroidViewModel(application) {

    private var repositorio : TerrenosRepositorio

    init {

        val terrenosDao = TerrenosDataBase.crearDatabase(application).obtenTerrenosDelDao()
        repositorio = TerrenosRepositorio(terrenosDao)

    }

    fun traemeLoDelServer() {

      repositorio.obtenDataDelServer()

    }

    fun exponeDatosDeDB():LiveData<List<TerrenosModelItem>> {
        return repositorio.exponeDatosDelBaseDeDatos()
    }
}