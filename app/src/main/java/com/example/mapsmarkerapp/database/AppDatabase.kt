package com.example.mapsmarkerapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mapsmarkerapp.dao.MarkerDao
import com.example.mapsmarkerapp.model.MarkerEntity

@Database(entities = [MarkerEntity::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract val markerDao : MarkerDao
}