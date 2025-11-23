package com.prasadvennam.local.data_source

import com.prasadvennam.data_source.local.RecentlyViewedLocalDataSource
import com.prasadvennam.local.dao.history.RecentlyViewedDao
import com.prasadvennam.local.entity.HistoryItemEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RecentlyViewedLocalDataSourceImpl @Inject constructor(
    private val recentlyViewedDao: RecentlyViewedDao
) : RecentlyViewedLocalDataSource {

    override suspend fun insertRecentlyViewedItem(
        item: HistoryItemEntity
    ) = recentlyViewedDao.insertRecentlyViewedItem(item = item)

    override fun getRecentlyViewedItems(): Flow<List<HistoryItemEntity>> =
        recentlyViewedDao.getRecentlyViewedItems()

    override suspend fun deleteRecentlyViewedItemById(
        id: Int
    ) = recentlyViewedDao.deleteRecentlyViewedItemById(id = id)
}