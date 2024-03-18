package com.raju.onecask.data.local.product.product_detail

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDetailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductDetail(
        companyListingEntities: List<ProductDetailEntity>
    )

    @Query("DELETE FROM product_detail")
    suspend fun deleteProductDetail()

    @Query(
        """
            SELECT * 
            FROM product_detail
            WHERE productId=:productId
        """
    )
    suspend fun getProductDetailByProductId(productId: Int): List<ProductDetailEntity>
}