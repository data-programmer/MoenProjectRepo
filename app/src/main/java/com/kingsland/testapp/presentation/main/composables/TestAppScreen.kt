package com.kingsland.testapp.presentation.main.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kingsland.testapp.presentation.main.model.DataState
import com.kingsland.testapp.presentation.main.viewmodel.DataViewModel

@Composable
internal fun TestAppScreen(
    viewModel: DataViewModel = hiltViewModel()
) {
    // We don't need remember {} because the viewModel is lifecycle aware
    val dataState = viewModel.dataState
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        when (dataState) {
            is DataState.Loading -> {
                TestAppLoading()
            }
            is DataState.Loaded -> {
                TestAppMain(dataState.data)
            }
            else -> {
                TestAppError { viewModel.getOfflineData() }
            }
        }
    }
}