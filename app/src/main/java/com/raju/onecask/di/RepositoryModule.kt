package com.raju.onecask.di

import android.app.Application
import com.raju.onecask.data.local.OneCaskDatabase
import com.raju.onecask.data.remote.OneCaskApi
import com.raju.onecask.data.repository.CollectionRepositoryImpl
import com.raju.onecask.domain.repository.CollectionRepository
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
    fun providesCoinRepository(
        application: Application,
        api: OneCaskApi,
        database: OneCaskDatabase
    ): CollectionRepository {
        return CollectionRepositoryImpl(application, api, database)
    }
}