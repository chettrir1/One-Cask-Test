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
    val details: List<ProductDetailModel>? = null,
    val notes: ProductTastingNoteModel? = null
)

data class ProductDetailModel(
    val title: String,
    val value: String
)

data class ProductTastingNoteModel(
    val noteBy: String,
    val notes: List<ProductTastingNoteListModel>? = null
)

data class ProductTastingNoteListModel(
    val notesId: Int,
    val notesTitle: String,
    val notesDescription: String
)