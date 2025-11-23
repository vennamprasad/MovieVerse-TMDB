package com.prasadvennam.data_source.remote

import com.prasadvennam.remote.dto.media_item.movie.MovieDto
import com.prasadvennam.remote.dto.actor.ActorDto
import com.prasadvennam.remote.dto.media_item.series.SeriesDto
import com.prasadvennam.remote.dto.suggestion.SuggestionDto
import com.prasadvennam.utils.ApiResponse

interface SearchRemoteDataSource {
    suspend fun searchMovie(query: String, page: Int, includeAdult: Boolean): ApiResponse<MovieDto>
    suspend fun searchSeries(query: String, page: Int, includeAdult: Boolean): ApiResponse<SeriesDto>
    suspend fun searchActor(query: String, page: Int, includeAdult: Boolean): ApiResponse<ActorDto>
    suspend fun searchByKeyword(keyword: String, page: Int, includeAdult: Boolean): ApiResponse<SuggestionDto>
}