package com.udhay.kollama.feature.settings.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udhay.kollama.feature.settings.domain.model.UserSettings
import com.udhay.kollama.feature.settings.domain.usecase.ClearUserSettingsUseCase
import com.udhay.kollama.feature.settings.domain.usecase.GetUserSettingsUseCase
import com.udhay.kollama.feature.settings.domain.usecase.SaveUserSettingsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.annotation.KoinViewModel

@KoinViewModel
class UserSettingsViewModel(
    private val getUserSettingsUseCase: GetUserSettingsUseCase,
    private val saveUserSettingsUseCase: SaveUserSettingsUseCase,
    private val clearUserSettingsUseCase: ClearUserSettingsUseCase
) : ViewModel() {

    private val _settings = MutableStateFlow(UserSettings())
    val settings: StateFlow<UserSettings> = _settings.asStateFlow()

    init {
        getSettings()
    }

    fun getSettings() {
        viewModelScope.launch {
            _settings.value = getUserSettingsUseCase()
        }
    }

    fun save(settings: UserSettings) {
        viewModelScope.launch {
            saveUserSettingsUseCase(settings)
            _settings.value = settings
        }
    }

    fun reset() {
        viewModelScope.launch {
            clearUserSettingsUseCase()
            _settings.value = UserSettings()
        }
    }
}
