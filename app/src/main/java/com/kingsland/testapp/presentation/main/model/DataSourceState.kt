package com.kingsland.testapp.presentation.main.model

import com.kingsland.testapp.data.model.Item

sealed class DataSourceState {
    object Loading: DataSourceState()
    data class Loaded(val data: List<Item>): DataSourceState()
    data class Error(val message: String): DataSourceState()
}
