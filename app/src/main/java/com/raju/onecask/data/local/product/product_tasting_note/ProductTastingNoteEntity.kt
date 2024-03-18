package com.raju.onecask.data.local.product.product_tasting_note

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.raju.onecask.data.remote.dto.ProductTastingNoteDto

@Entity(tableName = "product_tasting_note")
data class ProductTastingNoteEntity(
    val noteBy: String,
    val productId: Int,
    @PrimaryKey val tastingNoteId: Int? = null
)

fun ProductTastingNoteEntity.toProductTastingNote(notes: List<ProductTastingNoteEntity>): ProductTastingNoteDto {
    return ProductTastingNoteDto(
        noteBy = noteBy,
        tastingNoteId = tastingNoteId ?: -1,
        notes = emptyList()
    )
}

fun ProductTastingNoteDto.toProductTastingNoteEntity(productId: Int): ProductTastingNoteEntity {
    return ProductTastingNoteEntity(
        noteBy = noteBy,
        productId = productId,
        tastingNoteId = tastingNoteId
    )
}