package com.udhay.kollama.core.di

import com.udhay.kollama.feature.settings.domain.repository.UserSettingsRepository
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import org.udhay.ollama.OllamaClient
import org.udhay.ollama.OllamaClientConfig

@Module
class NetworkModule {

    @Single
    fun provideOllamaClient(repository: UserSettingsRepository): OllamaClient {
        return OllamaClient(
            configProvider = {
                val settings = repository.getUserSettings()
                OllamaClientConfig(
                    host = settings.serverHost,
                    headers = settings.serverHeaders
                )
            }
        )
    }
}
