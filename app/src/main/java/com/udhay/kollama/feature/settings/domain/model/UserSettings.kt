package com.udhay.kollama.feature.settings.domain.model

data class UserSettings(
    val username: String = "User",
    val occupation: String = "Developer",
    val personalPreferences: String = "I prefer concise answers",
    val darkModeEnabled: Boolean = false,
    val amoledPaletteEnabled: Boolean = false
)
