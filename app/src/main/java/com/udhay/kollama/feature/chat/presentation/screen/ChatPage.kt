package com.udhay.kollama.feature.chat.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ChatPage(
    modifier: Modifier = Modifier,
    onOpenSettings: () -> Unit
) {
    Scaffold { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text(
                text = "ChatPage",
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}
