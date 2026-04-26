package com.udhay.kollama.feature.settings.domain.usecase

import com.udhay.kollama.feature.settings.domain.model.UserSettings
import com.udhay.kollama.feature.settings.domain.repository.UserSettingsRepository

class GetUserSettingsUseCase(
    private val repository: UserSettingsRepository
) {
    suspend operator fun invoke(): UserSettings = repository.getUserSettings()
}