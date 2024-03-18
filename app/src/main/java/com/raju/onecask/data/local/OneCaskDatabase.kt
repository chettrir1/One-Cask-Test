package com.raju.onecask.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.raju.onecask.data.local.collection.CollectionDao
import com.raju.onecask.data.local.collection.CollectionEntity
import com.raju.onecask.data.local.product.ProductDao
import com.raju.onecask.data.local.product.ProductEntity
import com.raju.onecask.data.local.product.product_detail.ProductDetailDao
import com.raju.onecask.data.local.product.product_detail.ProductDetailEntity
import com.raju.onecask.data.local.product.product_tasting_note.ProductTastingNoteDao
import com.raju.onecask.data.local.product.product_tasting_note.ProductTastingNoteEntity
import com.raju.onecask.data.local.product.product_tasting_note.ProductTastingNoteListEntity
import com.raju.onecask.data.local.product.product_tasting_note.ProductTestNoteListDao

@Database(
    entities = [
        CollectionEntity::class,
        ProductEntity::class,
        ProductDetailEntity::class,
        ProductTastingNoteEntity::class,
        ProductTastingNoteListEntity::class],
    version = 1
)
abstract class OneCaskDatabase : RoomDatabase() {
    abstract val collectionDao: CollectionDao
    abstract val productDao: ProductDao
    abstract val productDetailDao: ProductDetailDao
    abstract val productTastingNoteDao: ProductTastingNoteDao
    abstract val productTastingNotesDao: ProductTestNoteListDao
}