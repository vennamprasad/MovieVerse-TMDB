package com.prasadvennam.domain.usecase.movie

import com.prasadvennam.domain.model.Movie
import com.prasadvennam.domain.repository.MovieRepository
import javax.inject.Inject

class GetMatchesYourVibesMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        genreId:Int,
        page:Int,
        forceRefresh: Boolean = false
    ): List<Movie> = movieRepository.getMatchYourVibeMovies(
        genreId = genreId,
        page = page,
        forceRefresh = forceRefresh
    )
}