package com.example.mapsmarkerapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Markers")
data class MarkerEntity(
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    var name : String,
    var age : Int,
    var relation : String,
    var address : String,
    var lat : Double,
    var long : Double
) {
    constructor() : this(0,"",0,"","",0.0,0.0)
}