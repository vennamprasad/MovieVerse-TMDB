package com.prasadvennam.data_source.remote

import com.prasadvennam.remote.dto.genre.GenreResponse

interface GenreRemoteDataSource {
    suspend fun getMoviesGenres(): GenreResponse
    suspend fun getSeriesGenres(): GenreResponse
}