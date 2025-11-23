package com.prasadvennam.data_source.local

import com.prasadvennam.local.entity.HistoryItemEntity
import kotlinx.coroutines.flow.Flow

interface RecentlyViewedLocalDataSource {
    suspend fun insertRecentlyViewedItem(item: HistoryItemEntity)
    fun getRecentlyViewedItems(): Flow<List<HistoryItemEntity>>
    suspend fun deleteRecentlyViewedItemById(id: Int)
}