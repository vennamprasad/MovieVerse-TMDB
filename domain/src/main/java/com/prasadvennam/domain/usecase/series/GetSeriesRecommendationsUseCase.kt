package com.prasadvennam.domain.usecase.series

import com.prasadvennam.domain.repository.SeriesRepository
import javax.inject.Inject

class GetSeriesRecommendationsUseCase @Inject constructor(
    private val seriesRepository: SeriesRepository
) {
    suspend operator fun invoke(id: Int, page: Int) =
        seriesRepository.getSeriesRecommendations(
            id = id,
            page = page
        ).distinctBy { it.id }
}