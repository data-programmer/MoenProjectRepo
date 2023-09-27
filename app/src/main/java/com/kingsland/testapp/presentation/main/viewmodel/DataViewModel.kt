package com.kingsland.testapp.presentation.main.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kingsland.testapp.domain.usecase.GetDataUseCase
import com.kingsland.testapp.presentation.main.model.DataState
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

    var dataState by mutableStateOf<DataState>(DataState.Loading)

    private fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            dataState = try {
                val result = getDataUseCase.getData()
                DataState.Loaded(result.items)
            } catch (exception: Exception) {
                DataState.Error(DataState.errorMessage)
            }
        }
    }
}