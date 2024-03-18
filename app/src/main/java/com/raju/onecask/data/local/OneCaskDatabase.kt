package com.raju.onecask.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.raju.onecask.data.local.collection.CollectionDao
import com.raju.onecask.data.local.collection.CollectionEntity
import com.raju.onecask.data.local.product.ProductDao
import com.raju.onecask.data.local.product.ProductEntity

@Database(
    entities = [CollectionEntity::class, ProductEntity::class],
    version = 1
)
abstract class OneCaskDatabase : RoomDatabase() {
    abstract val collectionDao: CollectionDao
    abstract val productDao: ProductDao
}