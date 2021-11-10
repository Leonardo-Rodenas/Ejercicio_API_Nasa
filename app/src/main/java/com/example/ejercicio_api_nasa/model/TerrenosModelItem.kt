package com.example.ejercicio_api_nasa.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "tabla_terrenos")
data class TerrenosModelItem(

    @PrimaryKey(autoGenerate = false)
    val id: String,

    val img_src: String,

    val price: Int,

    val type: String

)