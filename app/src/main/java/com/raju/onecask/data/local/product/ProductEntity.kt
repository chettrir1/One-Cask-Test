package com.raju.onecask.data.local.product

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.raju.onecask.data.remote.dto.ProductDto

@Entity(tableName = "product")
data class ProductEntity(
    val collectionId: Int,
    val name: String,
    val age: String,
    val code: String,
    @PrimaryKey val productId: Int? = null
)

fun ProductEntity.toProduct(): ProductDto {
    return ProductDto(
        name = name,
        age = age,
        code = code,
        productId = productId ?: -1
    )
}

fun ProductDto.toProductEntity(collectionId: Int): ProductEntity {
    return ProductEntity(
        name = name,
        age = age,
        code = code,
        productId = productId,
        collectionId = collectionId
    )
}