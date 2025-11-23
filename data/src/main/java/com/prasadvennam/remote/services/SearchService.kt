package com.prasadvennam.remote.services

import com.prasadvennam.remote.dto.media_item.movie.MovieDto
import com.prasadvennam.remote.dto.actor.ActorDto
import com.prasadvennam.remote.dto.media_item.series.SeriesDto
import com.prasadvennam.remote.dto.suggestion.SuggestionDto
import com.prasadvennam.utils.ApiResponse
import com.prasadvennam.utils.INCLUDE_ADULT
import com.prasadvennam.utils.PAGE
import com.prasadvennam.utils.QUERY
import com.prasadvennam.utils.SEARCH_ACTOR
import com.prasadvennam.utils.SEARCH_KEYWORD
import com.prasadvennam.utils.SEARCH_MOVIE
import com.prasadvennam.utils.SEARCH_SERIES
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Response

interface SearchService {

    @GET(SEARCH_MOVIE)
    suspend fun searchMovie(
        @Query(QUERY) query: String,
        @Query(PAGE) page: Int,
        @Query(INCLUDE_ADULT) includeAdult: Boolean = false
    ): Response<ApiResponse<MovieDto>>

    @GET(SEARCH_SERIES)
    suspend fun searchSeries(
        @Query(QUERY) query: String,
        @Query(PAGE) page: Int,
        @Query(INCLUDE_ADULT) includeAdult: Boolean = false
    ): Response<ApiResponse<SeriesDto>>

    @GET(SEARCH_ACTOR)
    suspend fun searchActor(
        @Query(QUERY) query: String,
        @Query(PAGE) page: Int,
        @Query(INCLUDE_ADULT) includeAdult: Boolean = false
    ): Response<ApiResponse<ActorDto>>

    @GET(SEARCH_KEYWORD)
    suspend fun getSuggestions(
        @Query(QUERY) keyword: String,
        @Query(PAGE) page: Int,
        @Query(INCLUDE_ADULT) includeAdult: Boolean = false
    ): Response<ApiResponse<SuggestionDto>>
}