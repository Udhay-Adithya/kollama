package com.udhay.kollama

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import com.udhay.kollama.core.ui.navigation.AppNavHost
import com.udhay.kollama.core.ui.theme.KollamaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val isDarkModeEnabled = rememberSaveable { mutableStateOf(false) }
            val isAmoledEnabled = rememberSaveable { mutableStateOf(false) }
            KollamaTheme(
                darkTheme = isDarkModeEnabled.value,
                isAmoled = isAmoledEnabled.value
            ) {
                AppNavHost(
                    isDarkTheme = { isDarkModeEnabled.value },
                    onToggleDarkTheme = { isDarkModeEnabled.value = it },
                    isAmoled = { isAmoledEnabled.value },
                    onToggleAmoled = { isAmoledEnabled.value = it }
                )
            }
        }
    }
}