package com.kingsland.testapp.presentation.main.model

import com.kingsland.testapp.data.model.Item

sealed class DataState {
    object Loading: DataState()
    data class Loaded(val data: List<Item>): DataState()
    data class Error(val message: String): DataState()

    companion object {
        const val errorMessage = "Oh, no! Looks like something went wrong. " +
                "Please try again later, or contact the developer."
    }
}
