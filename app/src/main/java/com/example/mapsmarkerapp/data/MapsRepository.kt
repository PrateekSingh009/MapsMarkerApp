package com.example.mapsmarkerapp.data

import com.example.mapsmarkerapp.dao.MarkerDao
import com.example.mapsmarkerapp.model.MarkerEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class MapsRepository @Inject constructor(val dao: MarkerDao) {

    fun insertMarkerInDB(marker: MarkerEntity?) {
        runBlocking(Dispatchers.IO) {
            marker?.let{
                dao.upsertMarker(it)
            }
        }
    }

    fun deleteMarkerFromDB(id : Int) {
        dao.deleteMarker(id)
    }

    fun getAllMarkers() : List<MarkerEntity> {
        return dao.getAllMarkers()
    }
}