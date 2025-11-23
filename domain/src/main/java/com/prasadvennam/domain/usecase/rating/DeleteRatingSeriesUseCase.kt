package com.prasadvennam.domain.usecase.rating

import com.prasadvennam.domain.repository.SeriesRepository
import javax.inject.Inject

class DeleteRatingSeriesUseCase @Inject constructor(
    private val seriesRepository: SeriesRepository
) {
    suspend operator fun invoke(
        id: Int
    ) = seriesRepository.deleteRatingSeries(seriesId = id)
}