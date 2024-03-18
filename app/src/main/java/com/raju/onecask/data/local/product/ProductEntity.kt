package com.raju.onecask.data.local.product

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.raju.onecask.data.local.product_detail.ProductDetailEntity
import com.raju.onecask.data.local.product_detail.toProductDetail
import com.raju.onecask.data.remote.dto.ProductDto

@Entity(tableName = "product")
data class ProductEntity(
    val collectionId: Int,
    val name: String,
    val age: String,
    val code: String,
    @PrimaryKey val productId: Int? = null
)

fun ProductEntity.toProduct(bottles: String, detail: List<ProductDetailEntity>): ProductDto {
    return ProductDto(
        name = name,
        age = age,
        code = code,
        productId = productId ?: -1,
        bottles = bottles,
        details = detail.map {
            it.toProductDetail()
        }

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