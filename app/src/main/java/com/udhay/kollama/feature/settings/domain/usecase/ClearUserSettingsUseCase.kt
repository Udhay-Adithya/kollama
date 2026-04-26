package com.udhay.kollama.feature.settings.domain.usecase

import com.udhay.kollama.feature.settings.domain.repository.UserSettingsRepository
import org.koin.core.annotation.Single

@Single
class ClearUserSettingsUseCase(
    private val repository: UserSettingsRepository
) {
    suspend operator fun invoke() {
        repository.clearUserSettings()
    }
}