package com.raju.onecask.data.repository

import android.app.Application
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.raju.onecask.data.local.OneCaskDatabase
import com.raju.onecask.data.local.collection.toCollection
import com.raju.onecask.data.local.collection.toCollectionEntity
import com.raju.onecask.data.local.label.toProductLabelEntity
import com.raju.onecask.data.local.product.product_detail.toProductDetailEntity
import com.raju.onecask.data.local.product.product_tasting_note.toProductNoteListEntity
import com.raju.onecask.data.local.product.product_tasting_note.toProductTastingNoteEntity
import com.raju.onecask.data.local.product.toProduct
import com.raju.onecask.data.local.product.toProductEntity
import com.raju.onecask.data.remote.OneCaskApi
import com.raju.onecask.data.remote.dto.CollectionDto
import com.raju.onecask.data.remote.dto.ProductDto
import com.raju.onecask.domain.repository.CollectionRepository
import javax.inject.Inject

class CollectionRepositoryImpl @Inject constructor(
    private val application: Application,
    private val api: OneCaskApi,
    private val database: OneCaskDatabase
) : CollectionRepository {

    override suspend fun getCollection(): List<CollectionDto> {
        val jsonString = readJsonFromAssets()
        val response = parseJsonToModel(jsonString = jsonString)
        response.let { datas ->
            database.collectionDao.deleteCollection()
            database.productDao.deleteProduct()
            database.productDetailDao.deleteProductDetail()
            database.productTastingNoteDao.deleteProductTastingNote()
            database.productTastingNotesDao.deleteProductTastingNoteList()
            database.productDetailDao.deleteProductDetail()
            database.productLabelDao.deleteProductLabel()
            database.collectionDao.insertCollection(datas.map { it.toCollectionEntity() })

            database.productDao.insertProduct(datas.mapNotNull { collection ->
                collection.product?.toProductEntity(collection.id)
            })

            datas.forEach { collection ->
                if (collection.product != null) {
                    database.productDetailDao.insertProductDetail(
                        collection.product!!.details.map {
                            it.toProductDetailEntity(collection.product!!.productId)
                        }
                    )
                    database.productTastingNoteDao.insertProductTastingNote(
                        collection.product!!.tastingNotes.toProductTastingNoteEntity(
                            collection.product!!.productId,
                            collection.product!!.tastingNotes.tastingNoteId
                        )
                    )

                    database.productTastingNotesDao.insertProductNoteList(collection.product!!.tastingNotes.notes.map {
                        it.toProductNoteListEntity(collection.product!!.tastingNotes.tastingNoteId)
                    })

                    database.productLabelDao.insertProductLabel(
                        collection.product!!.label.map {
                            it.toProductLabelEntity(collection.product!!.productId)
                        }
                    )
                }
            }

            datas.map {
                it.toCollectionEntity()
            }
        }
        return response
    }

    override suspend fun getCollectionFromLocal(): List<CollectionDto> {
        val localListings = database.collectionDao.getCollection()
        return localListings.map {
            it.toCollection()
        }
    }

    override suspend fun getProduct(collectionId: Int): ProductDto {
        val bottles = database.collectionDao.getBottlesByCollectionId(collectionId = collectionId)
        val data = database.productDao.getProductByCollectionId(collectionId = collectionId)

        val detail = database.productDetailDao.getProductDetailByProductId(data.productId ?: -1)
        val note =
            database.productTastingNoteDao.getProductTastingNoteByProductId(data.productId ?: -1)
        val notes =
            database.productTastingNotesDao.getProductTastingNoteListByTastingNoteId(1)
        val label = database.productLabelDao.getProductLabelByLabelId(data.productId ?: -1)

        return data.toProduct(bottles = bottles, detail, note, notes, label)
    }


    private fun readJsonFromAssets(): String {
        return application.assets.open("collection.json").bufferedReader().use { it.readText() }
    }

    private fun parseJsonToModel(jsonString: String): List<CollectionDto> {
        val gson = Gson()
        return gson.fromJson(jsonString, object : TypeToken<List<CollectionDto>>() {}.type)
    }
}