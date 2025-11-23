package com.prasadvennam.remote.services

import com.prasadvennam.remote.dto.media_item.common.MediaTrailersDto
import com.prasadvennam.remote.dto.media_item.common.SeriesCreditDto
import com.prasadvennam.remote.dto.media_item.series.SeriesDetailDto
import com.prasadvennam.remote.dto.media_item.series.SeriesDto
import com.prasadvennam.remote.dto.rating.request.RatingRequestDto
import com.prasadvennam.remote.dto.rating.response.RatedSeriesDto
import com.prasadvennam.remote.dto.rating.response.UserRatingResponse
import com.prasadvennam.remote.dto.review.ReviewDto
import com.prasadvennam.utils.ACCOUNT
import com.prasadvennam.utils.ACCOUNT_STATES
import com.prasadvennam.utils.ApiResponse
import com.prasadvennam.utils.DESCENDING
import com.prasadvennam.utils.DISCOVER_SERIES_LIST
import com.prasadvennam.utils.LATEST
import com.prasadvennam.utils.LISTS
import com.prasadvennam.utils.PAGE
import com.prasadvennam.utils.POPULAR
import com.prasadvennam.utils.RATED_SERIES
import com.prasadvennam.utils.RATING
import com.prasadvennam.utils.RECOMMENDATIONS
import com.prasadvennam.utils.REVIEWS
import com.prasadvennam.utils.SERIES
import com.prasadvennam.utils.SERIES_CREDITS
import com.prasadvennam.utils.SESSION_ID
import com.prasadvennam.utils.SORTED_BY
import com.prasadvennam.utils.TOP_RATED
import com.prasadvennam.utils.TRAILERS
import com.prasadvennam.utils.WITH_GENRES
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface SeriesService {
    @GET("$SERIES$POPULAR")
    suspend fun getPopularSeries(
        @Query(PAGE) page: Int
    ): Response<ApiResponse<SeriesDto>>

    @GET("$SERIES{id}")
    suspend fun getSeriesDetails(
        @Path("id") id: Int
    ): Response<SeriesDetailDto>

    @POST("$SERIES{series_id}$RATING")
    suspend fun rateSeries(
        @Path("series_id") id: Int,
        @Query(SESSION_ID) sessionId: String,
        @Body rating: RatingRequestDto
    ): Response<Unit>

    @DELETE("$SERIES{series_id}$RATING")
    suspend fun deleteRatingSeries(
        @Path("series_id") seriesId: Int,
        @Query(SESSION_ID) sessionId: String
    ): Response<Unit>

    @GET("$SERIES{series_id}$ACCOUNT_STATES")
    suspend fun getUserRatingForSeries(
        @Path("series_id") seriesId: Int,
        @Query(SESSION_ID) sessionId: String
    ): Response<UserRatingResponse>

    @GET("$ACCOUNT/{account_id}$RATED_SERIES")
    suspend fun getRatedSeries(
        @Path("account_id") id: Int,
        @Query(SESSION_ID) sessionId: String,
        @Query(PAGE) page: Int,
        @Query(SORTED_BY) sortBy: String = DESCENDING
    ): Response<ApiResponse<RatedSeriesDto>>

    @GET("$SERIES$LATEST")
    suspend fun getLatestSeasons()
            : Response<SeriesDetailDto>

    @GET("$SERIES{id}$LISTS")
    suspend fun getListOfSeries(
        @Path("id") id: Int,
        @Query("page") page: Int
    ): Response<ApiResponse<SeriesDto>>

    @GET("$SERIES{id}$REVIEWS")
    suspend fun getSeriesReviews(
        @Path("id") id: Int,
        @Query("page") page: Int
    ): Response<ApiResponse<ReviewDto>>

    @GET("$SERIES{series_id}$RECOMMENDATIONS")
    suspend fun getSeriesRecommendations(
        @Path("series_id") id: Int,
        @Query("page") page: Int
    ): Response<ApiResponse<SeriesDto>>

    @GET(DISCOVER_SERIES_LIST)
    suspend fun getSeriesByGenreId(
        @Query(WITH_GENRES) genreId: Int,
        @Query(PAGE) page: Int
    ): Response<ApiResponse<SeriesDto>>

    @GET("$SERIES{series_id}$SERIES_CREDITS")
    suspend fun getSeriesCredits(
        @Path("series_id") seriesId: Int
    ): Response<SeriesCreditDto>

    @GET("$SERIES{series_id}$TRAILERS")
    suspend fun getSeriesTrailers(
        @Path("series_id") seriesId: Int
    ): Response<MediaTrailersDto>

    @GET("$SERIES$TOP_RATED")
    suspend fun getTopRatedTVSeries(
        @Query(PAGE) page: Int
    ): Response<ApiResponse<SeriesDto>>


}
