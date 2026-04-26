package com.udhay.kollama.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.materialkolor.PaletteStyle
import com.materialkolor.dynamiccolor.ColorSpec
import com.materialkolor.rememberDynamicColorScheme

@Composable
fun KollamaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    isAmoled: Boolean = false,
    content: @Composable () -> Unit
) {
    val generatedColorScheme =
        rememberDynamicColorScheme(
            seedColor = seedColor,
            isDark = darkTheme,
            isAmoled = isAmoled,
            style = PaletteStyle.Fidelity,
            specVersion = ColorSpec.SpecVersion.SPEC_2025,
        )


    MaterialTheme(
        colorScheme = generatedColorScheme,
        typography = Typography,
        content = content
    )
}