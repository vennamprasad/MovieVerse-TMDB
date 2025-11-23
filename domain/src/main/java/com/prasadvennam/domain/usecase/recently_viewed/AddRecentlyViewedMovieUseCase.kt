package com.prasadvennam.domain.usecase.recently_viewed

import com.prasadvennam.domain.model.Movie
import com.prasadvennam.domain.repository.RecentlyViewedRepository
import javax.inject.Inject

class AddRecentlyViewedMovieUseCase @Inject constructor(
    private val repository: RecentlyViewedRepository
) {
    suspend operator fun invoke(
        movie: Movie
    ) = repository.addRecentlyViewedMovie(movie = movie)

}