package com.example.mapsmarkerapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Upsert
import androidx.room.Query
import com.example.mapsmarkerapp.model.MarkerEntity

@Dao
interface MarkerDao {

    @Upsert
    fun upsertMarker(marker : MarkerEntity)

    @Query("DELETE FROM Markers WHERE id = :id")
    fun deleteMarker(id : Int)

    @Query("SELECT * FROM Markers ORDER BY RANDOM()")
    fun getAllMarkers() : List<MarkerEntity>
}