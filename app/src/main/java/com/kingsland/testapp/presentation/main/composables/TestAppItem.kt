package com.kingsland.testapp.presentation.main.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.kingsland.testapp.R
import com.kingsland.testapp.data.model.Item

@Composable
fun TestAppItem(item: Item) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = item.capitalTitle ?: item.title,
                    fontSize = 22.sp
                )
                Text(
                    text = item.date ?: stringResource(R.string.unknown_date),
                    fontSize = 22.sp
                )
            }
            // A placeholder would normally be provided here
            AsyncImage(
                model = item.img,
                contentDescription = stringResource(R.string.image_image)
            )
            Text(
                text = item.description,
                fontSize = 14.sp
            )
        }
    }
}