package com.prasadvennam.utils

import com.prasadvennam.data_source.local.HomeLocalDataSource
import com.prasadvennam.domain.model.Movie
import com.prasadvennam.domain.model.Series
import com.prasadvennam.local.entity.MediaItemEntity
import com.prasadvennam.mapper.toHomeItemEntity
import javax.inject.Inject

class HomeCacheHelper @Inject constructor(
    private val homeLocalDataSource: HomeLocalDataSource
) {
    companion object {
        const val CACHE_DURATION_MS = 24 * 60 * 60 * 1000
    }

    internal suspend inline fun <reified T> getCachedOrFetchHomeItems(
        categoryType: String,
        crossinline mapFromEntity: (MediaItemEntity) -> T,
        fetchFromRemote: suspend () -> List<T>,
        forceRefresh: Boolean = false,
        forceCache: Boolean = false
    ): List<T> {
        if (forceCache) {
            return homeLocalDataSource.getHomeItemsByCategory(categoryType).map { mapFromEntity(it) }
        }

        val timestamp = homeLocalDataSource.getCategoryTimestamp(categoryType)
        val isExpired = timestamp == null || System.currentTimeMillis() - timestamp.lastRefreshed > CACHE_DURATION_MS

        if(forceRefresh || isExpired) {
            val remoteData = fetchFromRemote()
            val entities = remoteData.map {
                when (it) {
                    is Movie -> it.toHomeItemEntity(categoryType)
                    is Series -> it.toHomeItemEntity(categoryType)
                    else -> throw IllegalArgumentException("Unsupported type: ${T::class}")
                }
            }

            homeLocalDataSource.refreshHomeCategory(categoryType, entities)
            return remoteData
        }

        return homeLocalDataSource.getHomeItemsByCategory(categoryType).map { mapFromEntity(it) }
    }
}