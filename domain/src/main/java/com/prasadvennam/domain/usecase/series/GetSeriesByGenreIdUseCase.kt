package com.prasadvennam.domain.usecase.series

import com.prasadvennam.domain.repository.SeriesRepository
import javax.inject.Inject

class GetSeriesByGenreIdUseCase @Inject constructor(
    private val seriesRepository: SeriesRepository
) {
    suspend operator fun invoke(
        genreId: Int,
        page: Int
    ) = seriesRepository.getSeriesByGenreId(genreId, page).distinctBy { it.id }
}