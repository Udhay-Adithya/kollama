package com.udhay.kollama.feature.chat.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ChatHistoryListItem(
    title : String,
    modifier: Modifier = Modifier
) {
    ListItem(
        headlineContent = {
            Text(
                title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium
            )
        },
        colors = ListItemDefaults.colors().copy(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow
        ),
        modifier = Modifier
            .padding(all = 0.dp)
            .clickable { /* Handle click */ }
    )
}

@Preview(showBackground = true)
@Composable
private fun ChatHistoryListItemPreview() {
    ChatHistoryListItem("Kotlin Jetpack Compose Build Tools")
}
