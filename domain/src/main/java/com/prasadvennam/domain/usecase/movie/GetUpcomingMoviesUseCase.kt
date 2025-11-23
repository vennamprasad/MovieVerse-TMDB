package com.prasadvennam.domain.usecase.movie

import com.prasadvennam.domain.model.Movie
import com.prasadvennam.domain.repository.MovieRepository
import javax.inject.Inject

class GetUpcomingMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        page:Int,
        forceRefresh: Boolean = false
    ): List<Movie> = movieRepository.getUpComingMovies(
        page = page,
        forceRefresh = forceRefresh
    )
}