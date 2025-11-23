package com.prasadvennam.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.room.Room
import com.prasadvennam.data_source.local.DetailsLocalDataSource
import com.prasadvennam.data_source.local.GenreLocalDataSource
import com.prasadvennam.data_source.local.HomeLocalDataSource
import com.prasadvennam.data_source.local.RecentlyViewedLocalDataSource
import com.prasadvennam.data_source.local.SearchLocalDataSource
import com.prasadvennam.local.data_source.DetailsLocalDataSourceImpl
import com.prasadvennam.local.data_source.GenreLocalDataSourceImpl
import com.prasadvennam.local.data_source.HomeLocalDataSourceImpl
import com.prasadvennam.local.data_source.RecentlyViewedLocalDataSourceImpl
import com.prasadvennam.local.data_source.SearchLocalDataSourceImpl
import com.prasadvennam.local.database.MovieVerseDataBase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


private const val MOVIE_VERSE = "movie_verse"

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalSourceModule {

    @Binds
    @Singleton
    abstract fun bindSearchLocalDataSource(impl: SearchLocalDataSourceImpl): SearchLocalDataSource

    @Binds
    @Singleton
    abstract fun bindDetailsLocalDataSource(impl: DetailsLocalDataSourceImpl): DetailsLocalDataSource

    @Binds
    @Singleton
    abstract fun bindHomeLocalDataSource(impl: HomeLocalDataSourceImpl): HomeLocalDataSource

    @Binds
    @Singleton
    abstract fun bindRecentlyViewedLocalDataSource(impl: RecentlyViewedLocalDataSourceImpl): RecentlyViewedLocalDataSource

    @Binds
    @Singleton
    abstract fun bindGenreLocalDataSource(impl: GenreLocalDataSourceImpl): GenreLocalDataSource

    companion object {
        @Provides
        @Singleton
        fun provideMovieVerseDataBase(@ApplicationContext context: Context): MovieVerseDataBase {
            return Room.databaseBuilder(
                context,
                MovieVerseDataBase::class.java,
                MOVIE_VERSE
            ).fallbackToDestructiveMigration(true).build()
        }


        @Provides
        @Singleton
        fun provideSearchHistoryDao(database: MovieVerseDataBase) = database.searchHistoryDao()


        @Provides
        @Singleton
        fun provideFavouriteGenreDao(database: MovieVerseDataBase) = database.favouriteGenreDao()

        @Provides
        @Singleton
        fun provideHomeCacheDao(database: MovieVerseDataBase) = database.homeCacheDao()

        @Provides
        @Singleton
        fun provideRecentlyViewedDao(database: MovieVerseDataBase) = database.recentlyViewedDao()

        @Provides
        @Singleton
        fun provideGenreDao(database: MovieVerseDataBase) = database.genreDao()

        @Provides
        @Singleton
        fun provideDataStore(@ApplicationContext context: Context): DataStore<Preferences> {
            return PreferenceDataStoreFactory.create(
                produceFile = { context.preferencesDataStoreFile("movieverse_preferences") }
            )
        }
    }
}