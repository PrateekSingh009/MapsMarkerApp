package com.example.mapsmarkerapp.di

import android.content.Context
import androidx.room.Room
import com.example.mapsmarkerapp.dao.MarkerDao
import com.example.mapsmarkerapp.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context) : AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "MAPS_MARKER_DATABASE"
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideMarkerDao(appDatabase : AppDatabase) : MarkerDao {
        return appDatabase.markerDao
    }
}