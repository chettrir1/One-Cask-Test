package com.raju.onecask.data.local.product.product_detail

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.raju.onecask.data.remote.dto.ProductDetailDto

@Entity(tableName = "product_detail")
data class ProductDetailEntity(
    val productId: Int,
    val title: String,
    val value: String,
    @PrimaryKey(autoGenerate = true) val id: Int? = null
)

fun ProductDetailEntity.toProductDetail(): ProductDetailDto {
    return ProductDetailDto(
        title = title,
        value = value,
    )
}

fun ProductDetailDto.toProductDetailEntity(productId: Int): ProductDetailEntity {
    return ProductDetailEntity(
        productId = productId,
        title = title,
        value = value
    )
}