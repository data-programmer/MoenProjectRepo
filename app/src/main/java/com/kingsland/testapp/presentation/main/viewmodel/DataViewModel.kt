package com.kingsland.testapp.presentation.main.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kingsland.testapp.domain.usecase.GetDataUseCase
import com.kingsland.testapp.presentation.main.model.DataSourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(
    private val getDataUseCase: GetDataUseCase
): ViewModel() {

    init {
        getData()
    }

    var dataState by mutableStateOf<DataSourceState>(DataSourceState.Loading)

    private fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            dataState = try {
                val result = getDataUseCase.getData()
                DataSourceState.Loaded(result.items)
            } catch (exception: Exception) {
                DataSourceState.Error()
            }

        }
    }

    fun refreshData() {
        dataState = DataSourceState.Loading
        getData()
    }
}