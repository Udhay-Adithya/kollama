package com.udhay.kollama.feature.chat.domain.usecase

import com.udhay.kollama.feature.chat.domain.model.OllamaModel
import com.udhay.kollama.feature.chat.domain.repository.ModelsRepository
import org.koin.core.annotation.Factory

@Factory
class GetModelsUseCase(
    private val repository: ModelsRepository
) {

    suspend operator fun invoke() : List<OllamaModel>{
        return repository.getModels()
    }
}