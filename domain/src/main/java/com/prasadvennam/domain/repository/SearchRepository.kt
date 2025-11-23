package com.prasadvennam.domain.repository

import com.prasadvennam.domain.model.Actor
import com.prasadvennam.domain.model.Movie
import com.prasadvennam.domain.model.Series
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    suspend fun getLocalSuggestions(): Flow<List<String>>
    suspend fun deleteSearchHistory(searchTerm: String)
    suspend fun getRemoteSuggestions(keyWord: String, page: Int): List<String>
    suspend fun searchMovie(query: String, page: Int): Flow<List<Movie>>
    suspend fun searchSeries(
        query: String,
        page: Int
    ): Flow<List<Series>>

    suspend fun searchActor(query: String, page: Int): Flow<List<Actor>>
    suspend fun cacheSearchQuery(query: String)
    suspend fun clearSearchHistory()
}