package com.raju.onecask.data.repository

import android.app.Application
import com.example.cleanarchitecture.data.remote.OneCaskApi
import com.example.cleanarchitecture.data.remote.dto.CollectionDto
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.raju.onecask.domain.repository.CollectionRepository
import javax.inject.Inject

class CollectionRepositoryImpl @Inject constructor(
    private val application: Application,
    private val api: OneCaskApi
) : CollectionRepository {

    override suspend fun getCollection(): List<CollectionDto> {
        val jsonString = readJsonFromAssets()
        return parseJsonToModel(jsonString = jsonString)
    }

    private fun readJsonFromAssets(): String {
        return application.assets.open("collection.json").bufferedReader().use { it.readText() }
    }

    private fun parseJsonToModel(jsonString: String): List<CollectionDto> {
        val gson = Gson()
        return gson.fromJson(jsonString, object : TypeToken<List<CollectionDto>>() {}.type)
    }
}