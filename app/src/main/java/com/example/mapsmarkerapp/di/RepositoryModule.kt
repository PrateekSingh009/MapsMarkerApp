package com.example.mapsmarkerapp.di

import com.example.mapsmarkerapp.dao.MarkerDao
import com.example.mapsmarkerapp.data.MapsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(markerDao: MarkerDao) : MapsRepository {
        return MapsRepository(markerDao)
    }
}