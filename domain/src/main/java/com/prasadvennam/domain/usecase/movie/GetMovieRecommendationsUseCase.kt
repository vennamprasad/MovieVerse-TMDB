package com.prasadvennam.domain.usecase.movie

import com.prasadvennam.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieRecommendationsUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        id: Int,
        page: Int
    ) = movieRepository.getRecommendationsMovie(
            id = id,
            page = page
        )
}