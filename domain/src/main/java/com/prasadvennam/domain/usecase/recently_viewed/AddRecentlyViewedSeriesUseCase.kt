package com.prasadvennam.domain.usecase.recently_viewed

import com.prasadvennam.domain.model.Series
import com.prasadvennam.domain.repository.RecentlyViewedRepository
import javax.inject.Inject

class AddRecentlyViewedSeriesUseCase @Inject constructor(
    private val repository: RecentlyViewedRepository
) {
    suspend operator fun invoke(
        series: Series
    ) = repository.addRecentlyViewedSeries(series = series)
}