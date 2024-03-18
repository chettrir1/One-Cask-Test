package com.raju.onecask.presentation.collection

sealed class CollectionEvent {
    data object Refresh : CollectionEvent()
}