package com.udhay.kollama

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.udhay.kollama.core.ui.navigation.AppNavHost
import com.udhay.kollama.core.ui.theme.KollamaTheme
import com.udhay.kollama.feature.settings.presentation.viewmodel.UserSettingsViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val settingsViewModel: UserSettingsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val settings by settingsViewModel.settings.collectAsStateWithLifecycle()

            KollamaTheme(
                darkTheme = settings.darkModeEnabled,
                isAmoled = settings.amoledPaletteEnabled
            ) {
                AppNavHost()
            }
        }
    }
}