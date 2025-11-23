package com.prasadvennam.domain.usecase.search

import com.prasadvennam.domain.repository.SearchRepository
import javax.inject.Inject

class CacheSearchQueryUseCase @Inject constructor(
    private val searchRepository: SearchRepository
) {
    suspend operator fun invoke(
        query: String
    ) = searchRepository.cacheSearchQuery(query = query)
}