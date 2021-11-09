package com.example.ejercicio_api_nasa.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ejercicio_api_nasa.model.TerrenosModelItem

@Dao
interface TerrenosDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarTodosLosTerrenos(listaDeTerrenos: List<TerrenosModelItem>)

    @Query("SELECT * FROM tabla_terrenos")
    fun obtenerTodosLosTerrenosDeLaBD(): LiveData<List<TerrenosModelItem>>

}