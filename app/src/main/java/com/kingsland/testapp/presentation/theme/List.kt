package com.kingsland.testapp.presentation.theme

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kingsland.testapp.presentation.main.model.DataSourceState
import com.kingsland.testapp.presentation.main.viewmodel.DataViewModel

@Composable
fun DataList(

    viewModel: DataViewModel = hiltViewModel()
) {
    val dataState = viewModel.dataState
    when (dataState) {
        is DataSourceState.Loading -> {
            CircularProgressIndicator()
        }
        is DataSourceState.Loaded -> {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(dataState.data) { data ->
                    // TODO: remove for a better composable
                    Text(text = data.Title)
                }
            }
        }
        is DataSourceState.Error -> {
            Text(text = "There was an error.")
        }
    }
}