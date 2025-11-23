package com.prasadvennam.domain.repository

import com.prasadvennam.domain.model.Genre
interface GenreRepository {
    suspend fun getSeriesGenres(forceRefresh: Boolean = false): List<Genre>
    suspend fun getMoviesGenres(forceRefresh: Boolean = false): List<Genre>
}