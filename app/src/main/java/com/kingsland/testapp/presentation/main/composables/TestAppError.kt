package com.kingsland.testapp.presentation.main.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kingsland.testapp.R
import com.kingsland.testapp.presentation.main.model.DataState

@Composable
internal fun TestAppError(
    errorMessage: String = DataState.errorMessage,
    onOfflineClick: () -> Unit = {  }
) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(360.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(100.dp),
            painter = painterResource(R.drawable.error_image),
            contentDescription = stringResource(R.string.error_message)
        )
        Text(
            modifier = Modifier.padding(10.dp),
            text = errorMessage,
            textAlign = TextAlign.Center,
            fontSize = 16.sp
        )
        Button(
            onClick = onOfflineClick
        ) {
            Text(
                text = stringResource(R.string.get_offline_data),
                fontSize = 16.sp
            )
        }
    }
}