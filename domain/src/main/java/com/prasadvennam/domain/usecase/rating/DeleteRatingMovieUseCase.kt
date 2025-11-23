package com.prasadvennam.domain.usecase.rating

import com.prasadvennam.domain.repository.MovieRepository
import javax.inject.Inject

class DeleteRatingMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        movieId: Int
    ) = movieRepository.deleteRatingMovie(movieId = movieId)
}