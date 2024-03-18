package com.raju.onecask.data.local.product.product_tasting_note

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.raju.onecask.data.remote.dto.ProductTastingNoteListDto

@Entity(tableName = "product_tasting_notes")
data class ProductTastingNoteListEntity(
    val tastingNoteId: Int,
    val notesTitle: String,
    val notesDescription: String,
    @PrimaryKey(autoGenerate = true) val notesId: Int? = null
)

fun ProductTastingNoteListEntity.toProductTastingNoteList(): ProductTastingNoteListDto {
    return ProductTastingNoteListDto(
        noteId = notesId ?: -1,
        noteTitle = notesTitle,
        noteDescription = notesDescription
    )
}

fun ProductTastingNoteListDto.toProductNoteListEntity(tastingNoteId: Int): ProductTastingNoteListEntity {
    return ProductTastingNoteListEntity(
        notesDescription = noteDescription,
        notesTitle = noteTitle,
        tastingNoteId = tastingNoteId
    )
}