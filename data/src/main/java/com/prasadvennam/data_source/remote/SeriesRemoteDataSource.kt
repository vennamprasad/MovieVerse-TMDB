package com.prasadvennam.data_source.remote

import com.prasadvennam.remote.dto.media_item.common.MediaTrailersDto
import com.prasadvennam.remote.dto.media_item.common.SeriesCreditDto
import com.prasadvennam.remote.dto.media_item.series.SeriesDetailDto
import com.prasadvennam.remote.dto.media_item.series.SeriesDto
import com.prasadvennam.remote.dto.rating.request.RatingRequestDto
import com.prasadvennam.remote.dto.rating.response.RatedSeriesDto
import com.prasadvennam.remote.dto.rating.response.UserRatingResponse
import com.prasadvennam.remote.dto.review.ReviewDto
import com.prasadvennam.utils.ApiResponse

interface SeriesRemoteDataSource {
    suspend fun getPopularSeries(page: Int): ApiResponse<SeriesDto>
    suspend fun getSeriesDetails(id: Int): SeriesDetailDto
    suspend fun rateSeries(rating: RatingRequestDto, id: Int)
    suspend fun deleteRatingSeries(seriesId: Int)
    suspend fun getRatedSeries(userId: Int, page: Int): ApiResponse<RatedSeriesDto>
    suspend fun getUserRatingForSeries(seriesId: Int) : UserRatingResponse
    suspend fun getSeriesReviews(id: Int, page: Int): ApiResponse<ReviewDto>
    suspend fun getListOfSeries(id: Int, page: Int): ApiResponse<SeriesDto>
    suspend fun getLatestSeasons(): SeriesDetailDto
    suspend fun getSeriesRecommendations(id: Int, page: Int): ApiResponse<SeriesDto>
    suspend fun getSeriesByGenreId(genreId: Int, page: Int): ApiResponse<SeriesDto>
    suspend fun getTopRatedTVSeries(page: Int): ApiResponse<SeriesDto>
    suspend fun getSeriesCredits(seriesId: Int): SeriesCreditDto
    suspend fun getSeriesTrailers(seriesId: Int): MediaTrailersDto
}