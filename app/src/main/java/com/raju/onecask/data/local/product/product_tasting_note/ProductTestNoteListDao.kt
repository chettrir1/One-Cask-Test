package com.raju.onecask.data.local.product.product_tasting_note

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductTestNoteListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductNoteList(
        entities: List<ProductTastingNoteListEntity>
    )

    @Query("DELETE FROM product_tasting_notes")
    suspend fun deleteProductTastingNoteList()

    @Query(
        """
            SELECT * 
            FROM product_tasting_notes
            WHERE tastingNoteId=:tastingNoteId
        """
    )
    suspend fun getProductTastingNoteListByTastingNoteId(tastingNoteId: Int): List<ProductTastingNoteListEntity>
}