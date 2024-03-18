package com.raju.onecask.data.local.product.product_tasting_note

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductTastingNoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductTastingNote(
        companyListingEntities: List<ProductTastingNoteEntity>
    )

    @Query("DELETE FROM product")
    suspend fun deleteProductTastingNote()

    @Query(
        """
            SELECT * 
            FROM product_tasting_note
            WHERE productId=:productId
        """
    )
    suspend fun getProductByCollectionId(productId: Int): ProductTastingNoteEntity
}