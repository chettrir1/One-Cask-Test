package com.raju.onecask.presentation.collection

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raju.onecask.common.Resource
import com.raju.onecask.domain.usecase.collection.CollectionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CollectionViewModel @Inject constructor(
    private var useCase: CollectionUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CollectionListState())
    val state: State<CollectionListState> = _state

    init {
        getCollection()
    }

    fun onEvent(event: CollectionEvent) {
        when (event) {
            is CollectionEvent.Refresh -> {
                getCollection()
            }
        }
    }

    private fun getCollection() {
        useCase().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = CollectionListState(isLoading = true)
                }

                is Resource.Success -> {
                    _state.value = CollectionListState(collection = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value =
                        CollectionListState(
                            error = result.message ?: "An unexpected error occurred!"
                        )
                }
            }
        }.launchIn(viewModelScope)
    }
}