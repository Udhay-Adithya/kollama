package com.udhay.kollama.feature.settings.domain.usecase

import com.udhay.kollama.feature.settings.domain.repository.UserSettingsRepository

class ClearUserSettingsUseCase(
    private val repository: UserSettingsRepository
) {
    suspend operator fun invoke() {
        repository.clearUserSettings()
    }
}