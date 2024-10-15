package com.example.spotapp.di

import com.example.spotapp.Data.Local.PlaceDao
import com.example.spotapp.Data.Remote.PlaceApiService
import com.example.spotapp.Data.Repository.ListRepository
import com.example.spotapp.Data.Repository.ListRepositoryImpl
import com.example.spotapp.Data.Repository.PlaceRepository
import com.example.spotapp.Data.Repository.PlaceRepositoryImpl
import com.example.spotapp.Data.Repository.TipRepository
import com.example.spotapp.Data.Repository.TipRepositoryImpl
import com.example.spotapp.Domain.UseCase.AddTipUseCase
import com.example.spotapp.Domain.UseCase.GetListItemsUseCase
import com.example.spotapp.Domain.UseCase.GetNearbyPlacesUseCase
import com.example.spotapp.Domain.UseCase.GetPlaceByIdUseCase
import com.example.spotapp.Domain.UseCase.GetTipsForPlaceUseCase
import com.example.spotapp.Domain.UseCase.RatePlaceUseCase
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
        placeApiService: PlaceApiService,
        placeDao: PlaceDao // Added placeDao dependency
    ): PlaceRepository {
        return PlaceRepositoryImpl(placeApiService, placeDao) // Inject placeDao into the repository
    }

    // Add the ListRepository dependency
    @Provides
    @Singleton
    fun provideListRepository(
        placeDao: PlaceDao // Inject PlaceDao for list repository
    ): ListRepository {
        return ListRepositoryImpl(placeDao)
    }

    // Provide TipRepository for managing tips
    @Provides
    @Singleton
    fun provideTipRepository(
        placeDao: PlaceDao // Assume PlaceDao handles tips-related database operations
    ): TipRepository {
        return TipRepositoryImpl(placeDao)
    }

    // Add GetNearbyPlacesUseCase
    @Provides
    @Singleton
    fun provideGetNearbyPlacesUseCase(repository: PlaceRepository): GetNearbyPlacesUseCase {
        return GetNearbyPlacesUseCase(repository)
    }

    // Add GetPlaceByIdUseCase
    @Provides
    @Singleton
    fun provideGetPlaceByIdUseCase(repository: PlaceRepository): GetPlaceByIdUseCase {
        return GetPlaceByIdUseCase(repository)
    }

    // Add GetListItemsUseCase for fetching list data
    @Provides
    @Singleton
    fun provideGetListItemsUseCase(repository: ListRepository): GetListItemsUseCase {
        return GetListItemsUseCase(repository)
    }

    // Add RatePlaceUseCase for rating functionality
    @Provides
    @Singleton
    fun provideRatePlaceUseCase(repository: PlaceRepository): RatePlaceUseCase {
        return RatePlaceUseCase(repository)
    }

    // Add AddTipUseCase for adding tips to a place
    @Provides
    @Singleton
    fun provideAddTipUseCase(tipRepository: TipRepository): AddTipUseCase {
        return AddTipUseCase(tipRepository)
    }

    // Add GetTipsForPlaceUseCase for fetching tips of a place
    @Provides
    @Singleton
    fun provideGetTipsForPlaceUseCase(tipRepository: TipRepository): GetTipsForPlaceUseCase {
        return GetTipsForPlaceUseCase(tipRepository)
    }
}

