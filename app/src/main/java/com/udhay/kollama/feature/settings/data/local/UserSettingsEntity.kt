package com.udhay.kollama.feature.settings.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_settings")
data class UserSettingsEntity(

    @PrimaryKey
    val id: Int = 1, // Singleton row — only one user, always ID = 1

    // Identity
    val username: String = "",
    val occupation: String = "",

    // Preferences (free-form text, e.g. "I prefer concise answers")
    val personalPreferences: String = "I prefer concise answers",

    // Theme
    val darkModeEnabled: Boolean = false,
    val amoledPaletteEnabled: Boolean = false,

    // Timestamps
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)
