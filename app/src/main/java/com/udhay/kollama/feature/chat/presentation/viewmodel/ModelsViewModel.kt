package com.udhay.kollama.feature.chat.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udhay.kollama.feature.chat.domain.usecase.GetModelsUseCase
import com.udhay.kollama.feature.chat.presentation.state.ModelsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.core.annotation.KoinViewModel

@KoinViewModel
class ModelsViewModel(
    private val getModelsUseCase: GetModelsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<ModelsUiState>(ModelsUiState.Loading)
    val uiState: StateFlow<ModelsUiState> = _uiState

    init {
        getModels()
    }

    fun getModels() {
        viewModelScope.launch {
            _uiState.value = ModelsUiState.Loading

            try {
                val result = getModelsUseCase()

                if (result.isEmpty()) {
                    _uiState.value = ModelsUiState.Error("No models found or connection issue")
                } else {
                    _uiState.value = ModelsUiState.Success(result)
                }
            } catch (e: Exception) {
                _uiState.value = ModelsUiState.Error("Failed to connect to Ollama server")
            }
        }
    }
}
