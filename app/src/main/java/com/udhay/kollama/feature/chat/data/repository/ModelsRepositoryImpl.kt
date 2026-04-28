package com.udhay.kollama.feature.chat.data.repository

import com.udhay.kollama.feature.chat.data.model.toDomain
import com.udhay.kollama.feature.chat.domain.model.OllamaModel
import com.udhay.kollama.feature.chat.domain.repository.ModelsRepository
import org.koin.core.annotation.Single
import org.udhay.ollama.OllamaClient

@Single
class ModelsRepositoryImpl(private val ollamaClient: OllamaClient) : ModelsRepository {
    override suspend fun getModels(): List<OllamaModel> {
        val response = ollamaClient.list()
        return response.models.map { it.toDomain() }
    }
}