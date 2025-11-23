package com.prasadvennam.domain.usecase.movie

import com.prasadvennam.domain.model.Movie
import com.prasadvennam.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
) {
    suspend operator fun invoke(
        id: Int
    ): Movie = movieRepository.getDetailsMovie(id = id)
}