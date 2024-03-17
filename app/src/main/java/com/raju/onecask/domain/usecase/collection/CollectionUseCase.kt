package com.raju.onecask.domain.usecase.collection

import com.example.cleanarchitecture.data.remote.dto.toCollection
import com.raju.onecask.common.Resource
import com.raju.onecask.domain.model.CollectionModel
import com.raju.onecask.domain.repository.CollectionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CollectionUseCase @Inject constructor(private val repository: CollectionRepository) {

    operator fun invoke(): Flow<Resource<List<CollectionModel>>> = flow {
        try {
            emit(Resource.Loading())
            val collection = repository.getCollection().map { it.toCollection() }
            emit(Resource.Success(collection))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred!"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection!"))
        }
    }
}