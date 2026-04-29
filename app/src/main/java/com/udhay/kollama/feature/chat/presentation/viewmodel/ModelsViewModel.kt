package com.udhay.kollama.feature.chat.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udhay.kollama.feature.chat.domain.model.OllamaModel
import com.udhay.kollama.feature.chat.domain.usecase.GetModelsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.core.annotation.KoinViewModel

@KoinViewModel
class ModelsViewModel(
    private val getModelsUseCase: GetModelsUseCase
) : ViewModel() {
    private var _models = MutableStateFlow<
            List<OllamaModel>>(emptyList())

    val models: StateFlow<List<OllamaModel>> = _models

    private var _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    init {
        getModels()
    }

    fun getModels() {
        viewModelScope.launch {
            _error.value = null
            try {
                val result = getModelsUseCase()
                _models.value = result
                if (result.isEmpty()) {
                    _error.value = "No models found or connection issue"
                }
            } catch (e: Exception) {
                _error.value = "Failed to connect to Ollama server"
            }
        }
    }
}