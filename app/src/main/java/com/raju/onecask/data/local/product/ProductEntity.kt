package com.raju.onecask.data.local.product

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.raju.onecask.data.local.label.ProductLabelEntity
import com.raju.onecask.data.local.label.toProductLabel
import com.raju.onecask.data.local.product.product_detail.ProductDetailEntity
import com.raju.onecask.data.local.product.product_detail.toProductDetail
import com.raju.onecask.data.local.product.product_tasting_note.ProductTastingNoteEntity
import com.raju.onecask.data.local.product.product_tasting_note.ProductTastingNoteListEntity
import com.raju.onecask.data.local.product.product_tasting_note.toProductTastingNote
import com.raju.onecask.data.remote.dto.ProductDto

@Entity(tableName = "product")
data class ProductEntity(
    val collectionId: Int,
    val name: String,
    val age: String,
    val code: String,
    @PrimaryKey val productId: Int? = null
)

fun ProductEntity.toProduct(
    bottles: String,
    detail: List<ProductDetailEntity>,
    note: ProductTastingNoteEntity,
    notes: List<ProductTastingNoteListEntity>,
    label: List<ProductLabelEntity>
): ProductDto {
    return ProductDto(
        name = name,
        age = age,
        code = code,
        productId = productId ?: -1,
        bottles = bottles,
        details = detail.map {
            it.toProductDetail()
        },
        tastingNotes = note.toProductTastingNote(notes),
        label = label.map {
            it.toProductLabel()
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