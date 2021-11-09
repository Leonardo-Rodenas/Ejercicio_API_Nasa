package com.example.ejercicio_api_nasa.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class Factory(private val application: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom((TerrenosViewModel::class.java))) {
            return TerrenosViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}