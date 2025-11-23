package com.prasadvennam.domain.usecase.movie

import com.prasadvennam.domain.model.Movie
import com.prasadvennam.domain.repository.MovieRepository
import javax.inject.Inject

class GetRecentlyReleasedMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        page:Int,
        forceRefresh: Boolean = false
    ): List<Movie> = movieRepository.getRecentlyReleasedMovies(
        page = page,
        forceRefresh = forceRefresh
    )
}