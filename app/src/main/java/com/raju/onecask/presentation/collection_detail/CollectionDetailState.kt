package com.raju.onecask.presentation.collection_detail

import com.raju.onecask.domain.model.ProductModel

data class CollectionDetailState(
    val isLoading: Boolean = false,
    val product: ProductModel? = null,
    val isRefreshing: Boolean = false,
    val error: String = ""
)
