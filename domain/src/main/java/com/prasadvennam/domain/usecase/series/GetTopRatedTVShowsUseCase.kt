package com.prasadvennam.domain.usecase.series

import com.prasadvennam.domain.model.Series
import com.prasadvennam.domain.repository.SeriesRepository
import javax.inject.Inject

class GetTopRatedTVShowsUseCase @Inject constructor(
    private val seriesRepository: SeriesRepository
) {
    suspend operator fun invoke(
        page: Int,
        forceRefresh: Boolean = false
    ): List<Series> =
        seriesRepository.getTopRatedTVSeries(
            page = page,
            forceRefresh = forceRefresh
        )
}