package com.raju.onecask.data.remote.dto

import com.raju.onecask.domain.model.CollectionModel
import com.raju.onecask.domain.model.ProductDetailModel
import com.raju.onecask.domain.model.ProductModel

data class CollectionDto(
    val id: Int,
    val collectionName: String,
    val bottles: String,
    var product: ProductDto
)

data class ProductDto(
    val productId: Int,
    val name: String,
    val age: String,
    val code: String,
    var details: List<ProductDetailDto>? = null
)

data class ProductDetailDto(
    val title: String,
    val value: String
)

fun CollectionDto.toCollection(): CollectionModel {
    return CollectionModel(
        id = id,
        collectionName = collectionName,
        bottles = bottles,
        product = product?.toProduct()
    )
}

fun ProductDto.toProduct(): ProductModel {
    return ProductModel(
        productId = productId,
        name = name,
        age = age,
        code = code,
        details = details?.map {
            it.toProductDetail()
        }
    )
}

fun ProductDetailDto.toProductDetail(): ProductDetailModel {
    return ProductDetailModel(
        title = title,
        value = value
    )
}