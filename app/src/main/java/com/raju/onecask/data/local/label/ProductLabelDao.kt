package com.raju.onecask.data.local.label

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductLabelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductLabel(
        entities: List<ProductLabelEntity>
    )

    @Query("DELETE FROM product_label")
    suspend fun deleteProductLabel()

    @Query(
        """
            SELECT * 
            FROM product_label
            WHERE productId=:productId
        """
    )
    suspend fun getProductLabelByLabelId(productId: Int): List<ProductLabelEntity>
}