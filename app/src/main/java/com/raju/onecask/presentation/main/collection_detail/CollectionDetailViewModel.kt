package com.raju.onecask.presentation.main.collection_detail

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raju.onecask.common.Constants
import com.raju.onecask.common.Resource
import com.raju.onecask.domain.usecase.collection_detail.CollectionDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CollectionDetailViewModel @Inject constructor(
    private var useCase: CollectionDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CollectionDetailState())
    val state: State<CollectionDetailState> = _state

    init {
        savedStateHandle.get<Int>(Constants.PARAM_COLLECTION_ID)?.let { collectionId ->
            getCollectionDetail(collectionId)
        }
    }

    private fun getCollectionDetail(
        collectionId: Int
    ) {
        useCase(collectionId = collectionId).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = CollectionDetailState(isLoading = true)
                }

                is Resource.Success -> {
                    _state.value = CollectionDetailState(product = result.data)
                }

                is Resource.Error -> {
                    _state.value =
                        CollectionDetailState(
                            error = result.message ?: "An unexpected error occurred!"
                        )
                }
            }
        }.launchIn(viewModelScope)
    }
}