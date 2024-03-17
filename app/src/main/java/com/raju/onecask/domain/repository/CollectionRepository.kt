package com.raju.onecask.domain.repository

import com.example.cleanarchitecture.data.remote.dto.CollectionDto

interface CollectionRepository {

    suspend fun getCollection(): List<CollectionDto>

}