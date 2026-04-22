package com.udhay.kollama.feature.chat.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.udhay.kollama.R
import com.udhay.kollama.feature.chat.presentation.components.ChatDrawer
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatPage(
    modifier: Modifier = Modifier,
    onOpenSettings: () -> Unit,
) {
    val drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    fun toggleDrawer(){
        scope.launch {
            if (drawerState.isClosed) drawerState.open()
            else drawerState.close()
        }
    }


    ChatDrawer(
        onOpenSettings = onOpenSettings,
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { },
                    navigationIcon = {
                        IconButton(
                            onClick = { toggleDrawer() }
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.menu_24px),
                                contentDescription = "Menu"
                            )
                        }
                    }
                )
            }
        ) { paddingValues ->
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
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
}
