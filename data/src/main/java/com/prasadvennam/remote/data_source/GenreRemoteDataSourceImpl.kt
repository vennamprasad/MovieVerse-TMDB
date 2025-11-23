package com.prasadvennam.remote.data_source

import com.prasadvennam.data_source.remote.GenreRemoteDataSource
import com.prasadvennam.remote.dto.genre.GenreResponse
import com.prasadvennam.remote.services.GenreService
import com.prasadvennam.utils.handleApi
import javax.inject.Inject

class GenreRemoteDataSourceImpl  @Inject constructor(
    private val genreService: GenreService
) : GenreRemoteDataSource {
    override suspend fun getMoviesGenres(): GenreResponse =
        handleApi {
            genreService.getMoviesGenres()
        }

    override suspend fun getSeriesGenres(): GenreResponse =
        handleApi {
            genreService.getSeriesGenres()
        }
}