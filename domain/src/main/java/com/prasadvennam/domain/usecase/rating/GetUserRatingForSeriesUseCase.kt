package com.prasadvennam.domain.usecase.rating

import com.prasadvennam.domain.repository.SeriesRepository
import javax.inject.Inject

class GetUserRatingForSeriesUseCase @Inject constructor(
    private val seriesRepository: SeriesRepository
) {
    suspend operator fun invoke(
        seriesId: Int
    ) = seriesRepository.getUserRatingForSeries(seriesId = seriesId)
}