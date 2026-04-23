package com.udhay.kollama.core.ui.navigation

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.udhay.kollama.feature.chat.presentation.screen.ChatPage
import com.udhay.kollama.feature.settings.presentation.screen.SettingsPage
import kotlinx.coroutines.launch

@Composable
fun AppNavHost() {
    val backStack: SnapshotStateList<Routes> = remember { mutableStateListOf<Routes>(
        Routes.Chat
    ) }

    fun navigateTo(route: Routes){
        backStack.add(route)
    }
    
    fun popBack(){
        if (backStack.size > 1) {
            backStack.removeLast()
        }
    }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                is Routes.Chat -> NavEntry(key) {
                        ChatPage(
                            onOpenSettings = { navigateTo(Routes.Settings) },
                        )
                }

                is Routes.Settings -> NavEntry(key) {
                    SettingsPage(
                        onNavigateBack = { popBack() }
                    )
                }

//                else -> NavEntry(Unit) { Text("Unknown route") }
            }
        }
    )

}