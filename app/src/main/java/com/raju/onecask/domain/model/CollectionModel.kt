package com.raju.onecask.domain.model

data class CollectionModel(
    val id: Int,
    val collectionName: String,
    val bottles: String,
)

data class ProductModel(
    val productId: Int,
    val name: String,
    val age: String,
    val code: String,
    val bottles: String,
    val details: List<ProductDetailModel>? = null
)

data class ProductDetailModel(
    val title: String,
    val value: String
)