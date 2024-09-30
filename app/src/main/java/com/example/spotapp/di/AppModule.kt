package com.example.spotapp.di

import com.example.spotapp.Data.Remote.PlaceApiService
import com.example.spotapp.Data.Repository.PlaceRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton
@Module

@InstallIn(SingletonComponent::class)

object AppModule {
    @Provides
    @Singleton
    fun providePlaceApiService(retrofit: Retrofit): PlaceApiService {
        return retrofit.create(PlaceApiService::class.java)
    }

    @Provides
    @Singleton
    fun providePlaceRepository(
        placeApiService: PlaceApiService
    ): PlaceRepository {
        return PlaceRepositoryImpl(placeApiService)
    }
}