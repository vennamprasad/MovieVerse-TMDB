package com.prasadvennam.domain.usecase.search

import com.prasadvennam.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLocalSuggestionsUseCase @Inject constructor (
    private val searchRepository: SearchRepository
) {
    suspend operator fun invoke(): Flow<List<String>> =
        searchRepository.getLocalSuggestions()
}