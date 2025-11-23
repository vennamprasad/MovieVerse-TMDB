package com.prasadvennam.domain.usecase.rating

import com.prasadvennam.domain.repository.SeriesRepository
import javax.inject.Inject

class RateSeriesUseCase @Inject constructor(
    private val seriesRepository: SeriesRepository
) {
    suspend fun rateSeriesUse(
        rating: Float,
        seriesId: Int
    ) = seriesRepository.rateSeries(
        id = seriesId,
        rating = rating
    )
}