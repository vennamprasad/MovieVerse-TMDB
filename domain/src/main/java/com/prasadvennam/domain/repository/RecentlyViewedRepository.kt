package com.prasadvennam.domain.repository

import com.prasadvennam.domain.model.Movie
import com.prasadvennam.domain.model.Series
import kotlinx.coroutines.flow.Flow

interface RecentlyViewedRepository {
    suspend fun addRecentlyViewedMovie(movie: Movie)
    suspend fun addRecentlyViewedSeries(series: Series)
    suspend fun getRecentlyViewedMedia(): Flow<List<Any>>
    suspend fun deleteRecentlyViewedItemById(id: Int)
}