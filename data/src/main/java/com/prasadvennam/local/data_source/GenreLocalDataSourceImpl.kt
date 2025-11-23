package com.prasadvennam.local.data_source

import com.prasadvennam.data_source.local.GenreLocalDataSource
import com.prasadvennam.local.dao.genre.GenreDao
import com.prasadvennam.local.entity.GenreEntity
import javax.inject.Inject

class GenreLocalDataSourceImpl @Inject constructor(
    private val genreDao: GenreDao
): GenreLocalDataSource {
    override suspend fun getAllGenres(): List<GenreEntity> = genreDao.getAllGenres()
    override suspend fun insertGenres(genres: List<GenreEntity>) = genreDao.insertGenres(genres)
    override suspend fun clearGenres() = genreDao.clearGenres()
}