package com.prasadvennam.domain.usecase.movie

import com.prasadvennam.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieByGenreIdUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        genreId: Int,
        page: Int
    ) = movieRepository.getMoviesByGenreId(
        genreId = genreId,
        page = page
    ).distinctBy { it.id }
}