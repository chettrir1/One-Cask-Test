package com.raju.onecask.data.local.label

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.raju.onecask.data.remote.dto.ProductLabelDto

@Entity(tableName = "product_label")
data class ProductLabelEntity(
    val productId: Int,
    val title: String,
    val description: String,
    @PrimaryKey(autoGenerate = true) val id: Int? = null
)

fun ProductLabelEntity.toProductLabel(): ProductLabelDto {
    return ProductLabelDto(
        title = title,
        description = description,
    )
}

fun ProductLabelDto.toProductLabelEntity(productId: Int): ProductLabelEntity {
    return ProductLabelEntity(
        productId = productId,
        title = title,
        description = description
    )
}