package com.raju.onecask.presentation.main.collection

sealed class CollectionEvent {
    data object Refresh : CollectionEvent()
}