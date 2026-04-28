package com.udhay.kollama.core.di

import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import org.udhay.ollama.OllamaClient
import org.udhay.ollama.OllamaClientConfig

@Module
class NetworkModule {

    @Single
    fun provideOllamaClientConfig(): OllamaClientConfig {
        return OllamaClientConfig(
            host = "http://10.195.189.53:11434"
        )
    }

    @Single
    fun provideOllamaClient(config: OllamaClientConfig): OllamaClient {
        return OllamaClient(config)
    }
}