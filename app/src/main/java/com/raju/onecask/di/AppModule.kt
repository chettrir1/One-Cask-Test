package com.raju.onecask.di

import android.app.Application
import androidx.room.Room
import com.raju.onecask.common.Constants
import com.raju.onecask.data.local.OneCaskDatabase
import com.raju.onecask.data.remote.OneCaskApi
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
    fun providesOneCaskApi(): OneCaskApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OneCaskApi::class.java)
    }

    @Provides
    @Singleton
    fun provideOneCaskDatabase(app: Application): OneCaskDatabase {
        return Room.databaseBuilder(
            app,
            OneCaskDatabase::class.java,
            "one_cask.db"
        ).build()
    }
}