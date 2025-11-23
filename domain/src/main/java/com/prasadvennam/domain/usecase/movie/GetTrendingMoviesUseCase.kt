package com.prasadvennam.domain.usecase.movie

import com.prasadvennam.domain.repository.MovieRepository
import javax.inject.Inject

class GetTrendingMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        forceRefresh: Boolean = false
    ) = movieRepository.getTrendingMovies(forceRefresh)
}