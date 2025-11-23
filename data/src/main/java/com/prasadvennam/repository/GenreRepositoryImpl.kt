package com.prasadvennam.repository

import com.prasadvennam.data_source.remote.GenreRemoteDataSource
import com.prasadvennam.domain.model.Genre
import com.prasadvennam.domain.repository.GenreRepository
import com.prasadvennam.mapper.toDomain
import com.prasadvennam.mapper.toEntity
import com.prasadvennam.utils.GenreCacheHelper
import javax.inject.Inject

class GenreRepositoryImpl @Inject constructor(
    private val genreRemoteDataSource: GenreRemoteDataSource,
    private val genreCacheHelper: GenreCacheHelper
) : GenreRepository {

    override suspend fun getMoviesGenres(forceRefresh: Boolean): List<Genre> =
        genreCacheHelper.getCachedOrFetchGenres(
            fetchFromRemote = { genreRemoteDataSource.getMoviesGenres().genres },
            mapToDomain = { it.toDomain() },
            mapToEntity = { it.toEntity() },
            forceRefresh = forceRefresh
        )

    override suspend fun getSeriesGenres(forceRefresh: Boolean): List<Genre> =
        genreCacheHelper.getCachedOrFetchGenres(
            fetchFromRemote = { genreRemoteDataSource.getSeriesGenres().genres },
            mapToDomain = { it.toDomain() },
            mapToEntity = { it.toEntity() },
            forceRefresh = forceRefresh
        )
}