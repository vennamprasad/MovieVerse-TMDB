package com.prasadvennam.domain.service.language

import kotlinx.coroutines.flow.StateFlow

interface LanguageProvider {
    val currentLanguage: StateFlow<String>
    suspend fun setLanguage(language: String)
    fun getCurrentLanguage(): String
}
