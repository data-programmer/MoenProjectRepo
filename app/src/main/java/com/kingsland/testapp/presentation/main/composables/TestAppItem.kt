package com.kingsland.testapp.presentation.main.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.kingsland.testapp.R
import com.kingsland.testapp.data.model.Item

@Composable
internal fun TestAppItem(item: Item) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(350.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = item.capitalTitle ?: item.title ?: "",
                    fontSize = 22.sp
                )
                // TODO: The date can be parsed into a more readable format
                Text(
                    text = item.date ?: stringResource(R.string.unknown_date),
                    fontSize = 18.sp
                )
            }
            // A placeholder would normally be provided here
            // You can also use a "loading" placeholder
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                model = item.img,
                contentDescription = stringResource(R.string.image_image)
            )
            Text(
                text = item.description,
                fontSize = 14.sp,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TestAppItemPreview() {
    TestAppItem(
        item = Item(
            capitalTitle = "This is a title",
            date = "9/30/2022",
            description = "This is the description of the item.",
            img = "",
            title = "This is another title"
        )
    )
}