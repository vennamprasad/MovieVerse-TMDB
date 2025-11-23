package com.prasadvennam.domain.usecase.search

import com.prasadvennam.domain.repository.SearchRepository
import javax.inject.Inject

class ClearSearchHistoryUseCase @Inject constructor(
    private val searchRepository: SearchRepository
) {
    suspend operator fun invoke() = searchRepository.clearSearchHistory()
}