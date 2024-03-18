package com.raju.onecask.domain.usecase.collection

import android.app.Application
import com.raju.onecask.common.Resource
import com.raju.onecask.data.remote.dto.toCollection
import com.raju.onecask.domain.model.CollectionModel
import com.raju.onecask.domain.repository.CollectionRepository
import com.raju.onecask.utils.checkNetworkAvailability
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CollectionUseCase @Inject constructor(
    private val application: Application,
    private val repository: CollectionRepository
) {

    operator fun invoke(): Flow<Resource<List<CollectionModel>>> = flow {
        try {
            emit(Resource.Loading())
            val collection: List<CollectionModel> = if (checkNetworkAvailability(application)) {
                repository.getCollection().map { it.toCollection() }
            } else {
                repository.getCollectionFromLocal().map { it.toCollection() }
            }
            emit(Resource.Success(collection))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred!"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection!"))
        }
    }
}