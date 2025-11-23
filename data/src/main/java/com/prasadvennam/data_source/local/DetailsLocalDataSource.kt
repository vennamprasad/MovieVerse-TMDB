package com.prasadvennam.data_source.local

import com.prasadvennam.local.entity.FavouriteGenreEntity
import kotlinx.coroutines.flow.Flow

interface DetailsLocalDataSource {
    suspend fun insertFavouriteGenre(genreId: Int)
    suspend fun incrementGenreCount(genreId: Int)
    suspend fun getFavouriteGenres(): Flow<List<FavouriteGenreEntity>>
}