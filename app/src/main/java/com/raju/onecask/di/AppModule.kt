package com.example.cleanarchitecture.di

import android.app.Application
import com.example.cleanarchitecture.data.remote.OneCaskApi
import com.raju.onecask.common.Constants
import com.raju.onecask.data.repository.CollectionRepositoryImpl
import com.raju.onecask.domain.repository.CollectionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesPaprikaApi(): OneCaskApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OneCaskApi::class.java)
    }

    @Provides
    @Singleton
    fun providesCoinRepository(application: Application, api: OneCaskApi): CollectionRepository {
        return CollectionRepositoryImpl(application, api)
    }
}