package com.example.ejercicio_api_nasa.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ejercicio_api_nasa.dao.TerrenosDao
import com.example.ejercicio_api_nasa.model.TerrenosModelItem

@Database(entities = [TerrenosModelItem::class], version = 1)
abstract class TerrenosDataBase : RoomDatabase() {

    abstract fun obtenTerrenosDelDao(): TerrenosDao

    companion object {

        @Volatile
        private var baseDeDatosCreada: TerrenosDataBase? = null

        fun crearDatabase(context: Context): TerrenosDataBase {

            if (baseDeDatosCreada == null) {
                synchronized(this)
                {
                    baseDeDatosCreada = Room.databaseBuilder(
                        context,
                        TerrenosDataBase::class.java,
                        "base_De_Datos_Terrenos"
                    ).build()
                }
            }
            return baseDeDatosCreada!!
        }

    }
}