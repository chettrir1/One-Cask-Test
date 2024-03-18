package com.raju.onecask.domain.usecase.collection_detail

import com.raju.onecask.common.Resource
import com.raju.onecask.data.remote.dto.toProduct
import com.raju.onecask.domain.model.ProductModel
import com.raju.onecask.domain.repository.CollectionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CollectionDetailUseCase @Inject constructor(private val repository: CollectionRepository) {

    operator fun invoke(collectionId: Int): Flow<Resource<ProductModel>> = flow {
        try {
            emit(Resource.Loading())
            val product = repository.getProduct(collectionId).toProduct()
            emit(Resource.Success(product))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred!"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection!"))
        }
    }
}