package com.udhay.kollama.feature.settings.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.udhay.kollama.R

@Composable
fun SettingsListItem(
    modifier: Modifier = Modifier,
    title: String,
    isFirst: Boolean = false,
    isLast: Boolean = false,
    onTap: () -> Unit,
    leadingIcon: Painter,
    trailingIcon: Painter = painterResource(R.drawable.chevron_right_24px),
) {
    val shape = RoundedCornerShape(
        topStart = if (isFirst) 12.dp else 0.dp,
        topEnd = if (isFirst) 12.dp else 0.dp,
        bottomStart = if (isLast) 12.dp else 0.dp,
        bottomEnd = if (isLast) 12.dp else 0.dp
    )

    ListItem(
        leadingContent = { Icon(painter = leadingIcon, contentDescription = null) },
        trailingContent = {
            Icon(
                painter = trailingIcon,
                contentDescription = null
            )
        },
        colors = ListItemDefaults.colors()
            .copy(containerColor = MaterialTheme.colorScheme.surfaceContainerLow),
        modifier = modifier
            .clip(shape = shape)
            .clickable() {
                onTap()
            },
        headlineContent = {
            Text(title)
        }
    )

}

@Preview(showBackground = true)
@Composable
private fun SettingsListItemPreview() {
    SettingsListItem(
        onTap = {},
        title = "Account Settings",
        leadingIcon = painterResource(R.drawable.person_24px),
        isFirst = true,
        isLast = true,
    )
}
