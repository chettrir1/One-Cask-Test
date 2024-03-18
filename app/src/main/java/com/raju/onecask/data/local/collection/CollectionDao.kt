package com.raju.onecask.data.local.collection

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CollectionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCollection(
        companyListingEntities: List<CollectionEntity>
    )

    @Query("DELETE FROM collection")
    suspend fun deleteCollection()

    @Query(
        """
            SELECT * 
            FROM collection
        """
    )
    suspend fun getCollection(): List<CollectionEntity>
}