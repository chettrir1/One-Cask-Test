package com.raju.onecask.data.local.product

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(
        companyListingEntities: List<ProductEntity>
    )

    @Query("DELETE FROM product")
    suspend fun deleteProduct()

    @Query(
        """
            SELECT * 
            FROM product
            WHERE collectionId=:collectionId
        """
    )
    suspend fun getProductByCollectionId(collectionId: Int): ProductEntity
}