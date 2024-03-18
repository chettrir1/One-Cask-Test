package com.raju.onecask.presentation.main.collection

import com.raju.onecask.domain.model.CollectionModel

data class CollectionListState(
    val isLoading: Boolean = false,
    val collection: List<CollectionModel> = emptyList(),
    val isRefreshing: Boolean = false,
    val error: String = ""
)
