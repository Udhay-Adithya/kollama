package com.udhay.kollama.feature.chat.domain.model

import kotlinx.serialization.json.JsonElement

data class OllamaModel (
    val name: String? = null,
    val model: String? = null,
    val modifiedAt: String? = null,
    val size: Long? = null,
    val digest: String? = null,
    val details: JsonElement? = null
)