package com.udhay.kollama.feature.settings.data.model

import com.udhay.kollama.feature.settings.data.local.UserSettingsEntity
import com.udhay.kollama.feature.settings.domain.model.UserSettings

fun UserSettingsEntity.toDomain() = UserSettings(
    username = username,
    occupation = occupation,
    personalPreferences = personalPreferences,
    darkModeEnabled = darkModeEnabled,
    amoledPaletteEnabled = amoledPaletteEnabled
)

fun UserSettings.toEntity() = UserSettingsEntity(
    id = 1,
    username = username,
    occupation = occupation,
    personalPreferences = personalPreferences,
    darkModeEnabled = darkModeEnabled,
    amoledPaletteEnabled = amoledPaletteEnabled,
    updatedAt = System.currentTimeMillis()
)