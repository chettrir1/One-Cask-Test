package com.raju.onecask.domain.repository

import com.raju.onecask.data.remote.dto.CollectionDto

interface CollectionRepository {
    suspend fun getCollection(): List<CollectionDto>
    suspend fun getCollectionFromLocal(): List<CollectionDto>

}