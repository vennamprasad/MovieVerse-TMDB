package com.prasadvennam.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.prasadvennam.local.dao.genre.GenreDao
import com.prasadvennam.local.dao.history.RecentlyViewedDao
import com.prasadvennam.local.dao.home.HomeCacheDao
import com.prasadvennam.local.dao.search.FavouriteGenreDao
import com.prasadvennam.local.dao.search.SearchHistoryDao
import com.prasadvennam.local.entity.FavouriteGenreEntity
import com.prasadvennam.local.entity.GenreEntity
import com.prasadvennam.local.entity.HistoryItemEntity
import com.prasadvennam.local.entity.HomeCategoryTimestampEntity
import com.prasadvennam.local.entity.MediaItemEntity
import com.prasadvennam.local.entity.SearchHistoryEntity

@Database(
    entities = [
        SearchHistoryEntity::class,
        FavouriteGenreEntity::class,
        MediaItemEntity::class,
        HomeCategoryTimestampEntity::class,
        HistoryItemEntity::class,
        GenreEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class MovieVerseDataBase : RoomDatabase() {
    abstract fun searchHistoryDao(): SearchHistoryDao
    abstract fun favouriteGenreDao(): FavouriteGenreDao
    abstract fun homeCacheDao(): HomeCacheDao
    abstract fun recentlyViewedDao(): RecentlyViewedDao
    abstract fun genreDao(): GenreDao
}