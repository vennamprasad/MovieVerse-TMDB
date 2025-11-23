package com.prasadvennam.domain.usecase.series

import com.prasadvennam.domain.model.Series
import com.prasadvennam.domain.repository.SeriesRepository
import javax.inject.Inject

class GetSeriesDetailUseCase @Inject constructor(
    private val seriesRepository: SeriesRepository
) {
    suspend operator fun invoke(
        id: Int
    ): Series = seriesRepository.getSeriesDetail(id = id)
}