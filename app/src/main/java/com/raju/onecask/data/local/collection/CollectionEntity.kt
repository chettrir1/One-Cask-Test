package com.raju.onecask.data.local.collection

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.raju.onecask.data.remote.dto.CollectionDto
import com.raju.onecask.data.remote.dto.ProductDto

@Entity(tableName = "collection")
data class CollectionEntity(
    val collectionName: String,
    val bottles: String,
    @PrimaryKey val id: Int? = null
)

fun CollectionEntity.toCollection(): CollectionDto {
    return CollectionDto(
        id = id ?: -1,
        collectionName = collectionName,
        bottles = bottles,
        product = ProductDto("", -1, "", "", "", emptyList())
    )
}

fun CollectionDto.toCollectionEntity(): CollectionEntity {
    return CollectionEntity(
        id = id,
        collectionName = collectionName,
        bottles = bottles
    )
}