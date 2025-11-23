package com.prasadvennam.mapper

import com.prasadvennam.remote.dto.suggestion.SuggestionDto

fun SuggestionDto.toModel(): String {
    return this.name ?: ""
}