package com.prasadvennam.data_source.local

import com.prasadvennam.local.entity.GenreEntity

interface GenreLocalDataSource {
    suspend fun getAllGenres(): List<GenreEntity>
    suspend fun insertGenres(genres: List<GenreEntity>)
    suspend fun clearGenres()
}