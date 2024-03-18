package com.raju.onecask.data.repository

import android.app.Application
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.raju.onecask.data.local.OneCaskDatabase
import com.raju.onecask.data.local.collection.toCollection
import com.raju.onecask.data.local.collection.toCollectionEntity
import com.raju.onecask.data.local.product.product_detail.toProductDetailEntity
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
            database.collectionDao.insertCollection(datas.map { it.toCollectionEntity() })

            database.productDao.insertProduct(datas.map { collection ->
                collection.product.toProductEntity(collection.id)
            })

            datas.forEach { collection ->
                database.productDetailDao.insertProductDetail(
                    collection.product.details.map {
                        it.toProductDetailEntity(collection.product.productId)
                    }
                )

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
        return data.toProduct(bottles = bottles, detail)
    }


    private fun readJsonFromAssets(): String {
        return application.assets.open("collection.json").bufferedReader().use { it.readText() }
    }

    private fun parseJsonToModel(jsonString: String): List<CollectionDto> {
        val gson = Gson()
        return gson.fromJson(jsonString, object : TypeToken<List<CollectionDto>>() {}.type)
    }
}