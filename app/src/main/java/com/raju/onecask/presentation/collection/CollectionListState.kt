package com.raju.onecask.presentation.collection

import com.raju.onecask.domain.model.CollectionModel

data class CollectionListState(
    val isLoading: Boolean = false,
    val collection: List<CollectionModel> = emptyList(),
    val error: String = ""
)
