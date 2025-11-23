package com.prasadvennam.domain.usecase.search

import com.prasadvennam.domain.repository.SearchRepository
import javax.inject.Inject

class SearchUseCase @Inject constructor(
    private val searchRepository: SearchRepository,
) {
    suspend fun searchMovie(
        query: String,
        page: Int
    ) = searchRepository.searchMovie(
        query = query,
        page = page
    )

    suspend fun searchSeries(
        query: String,
        page: Int
    ) = searchRepository.searchSeries(
        query = query,
        page = page
    )

    suspend fun searchActor(
        query: String,
        page: Int
    ) = searchRepository.searchActor(
        query = query,
        page = page
    )
}