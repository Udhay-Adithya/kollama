package com.udhay.kollama.feature.settings.domain.repository

import com.udhay.kollama.feature.settings.domain.model.UserSettings

interface UserSettingsRepository {
    suspend fun getUserSettings(): UserSettings
    suspend fun saveUserSettings(settings: UserSettings)
    suspend fun clearUserSettings()
}