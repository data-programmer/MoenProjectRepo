package com.kingsland.testapp.presentation.main.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kingsland.testapp.R
import com.kingsland.testapp.presentation.main.model.DataState

@Composable
internal fun TestAppError(
    errorMessage: String = DataState.errorMessage
) {
    Column(
        modifier = Modifier.width(340.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(100.dp),
            painter = painterResource(R.drawable.error_image),
            contentDescription = "Error message image"
        )
        Text(
            text = errorMessage,
            textAlign = TextAlign.Center,
            fontSize = 16.sp
        )
    }
}