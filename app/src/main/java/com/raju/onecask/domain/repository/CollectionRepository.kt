package com.raju.onecask.domain.repository

import com.raju.onecask.data.remote.dto.CollectionDto
import com.raju.onecask.data.remote.dto.ProductDto

interface CollectionRepository {
    suspend fun getCollection(): List<CollectionDto>
    suspend fun getCollectionFromLocal(): List<CollectionDto>
    suspend fun getProduct(collectionId: Int): ProductDto

}