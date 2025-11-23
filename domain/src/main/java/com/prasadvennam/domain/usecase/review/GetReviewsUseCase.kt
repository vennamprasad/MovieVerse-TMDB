package com.prasadvennam.domain.usecase.review

import com.prasadvennam.domain.model.Review
import com.prasadvennam.domain.repository.MovieRepository
import com.prasadvennam.domain.repository.SeriesRepository
import javax.inject.Inject

class GetReviewsUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val seriesRepository: SeriesRepository
) {
    suspend operator fun invoke(
        id: Int,
        page: Int,
        isMovie: Boolean
    ): List<Review> =
        if (isMovie) {
            movieRepository.getReviewsMovie(
                id = id,
                page = page
            )
        } else {
            seriesRepository.getSeriesReviews(
                id = id,
                page = page
            )
        }
}