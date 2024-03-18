package com.raju.onecask.data.remote.dto

import com.raju.onecask.domain.model.CollectionModel
import com.raju.onecask.domain.model.ProductDetailModel
import com.raju.onecask.domain.model.ProductModel
import com.raju.onecask.domain.model.ProductTastingNoteListModel
import com.raju.onecask.domain.model.ProductTastingNoteModel

data class CollectionDto(
    val id: Int,
    val collectionName: String,
    val bottles: String,
    var product: ProductDto
)

data class ProductDto(
    val bottles: String,
    val productId: Int,
    val name: String,
    val age: String,
    val code: String,
    var details: List<ProductDetailDto>,
)

data class ProductDetailDto(
    val title: String,
    val value: String
)

data class ProductTastingNoteDto(
    val tastingNoteId: Int,
    val noteBy: String,
    val notes: List<ProductTastingNoteListDto>
)

data class ProductTastingNoteListDto(
    val notesId: Int,
    val notesTitle: String,
    val notesDescription: String
)

fun CollectionDto.toCollection(): CollectionModel {
    return CollectionModel(
        id = id,
        collectionName = collectionName,
        bottles = bottles
    )
}

fun ProductDto.toProduct(): ProductModel {
    return ProductModel(
        productId = productId,
        name = name,
        age = age,
        code = code,
        bottles = bottles,
        details = details.map {
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

fun ProductTastingNoteDto.toProductNote(): ProductTastingNoteModel {
    return ProductTastingNoteModel(
        noteBy = noteBy,
        notes = notes?.map {
            it.toProductNotes()
        }
    )
}

fun ProductTastingNoteListDto.toProductNotes(): ProductTastingNoteListModel {
    return ProductTastingNoteListModel(
        notesId = notesId,
        notesTitle = notesTitle,
        notesDescription = notesDescription
    )
}
