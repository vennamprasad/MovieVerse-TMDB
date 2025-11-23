package com.prasadvennam.remote.data_source

import com.prasadvennam.data_source.remote.SeriesRemoteDataSource
import com.prasadvennam.domain.repository.auth.UserRepository
import com.prasadvennam.remote.dto.media_item.common.MediaTrailersDto
import com.prasadvennam.remote.dto.media_item.series.SeriesDetailDto
import com.prasadvennam.remote.dto.media_item.series.SeriesDto
import com.prasadvennam.remote.dto.rating.request.RatingRequestDto
import com.prasadvennam.remote.dto.rating.response.RatedSeriesDto
import com.prasadvennam.remote.dto.rating.response.UserRatingResponse
import com.prasadvennam.remote.dto.review.ReviewDto
import com.prasadvennam.remote.services.SeriesService
import com.prasadvennam.utils.ApiResponse
import com.prasadvennam.utils.handleApi
import javax.inject.Inject

class SeriesRemoteDataSourceImpl @Inject constructor(
    private val seriesService: SeriesService,
    private val userRepository: UserRepository
) : SeriesRemoteDataSource {

    override suspend fun getPopularSeries(page: Int): ApiResponse<SeriesDto> =
        handleApi {
            seriesService.getPopularSeries(page)
        }

    override suspend fun getSeriesDetails(id: Int): SeriesDetailDto =
        handleApi {
            seriesService.getSeriesDetails(id)
        }

    override suspend fun rateSeries(rating: RatingRequestDto, id: Int) {
        val sessionId = userRepository.getSessionId()
        handleApi {
            seriesService.rateSeries(
                id,
                sessionId,
                rating
            )
        }
    }

    override suspend fun deleteRatingSeries(seriesId: Int){
        val sessionId = userRepository.getSessionId()
        handleApi {
            seriesService.deleteRatingSeries(
                seriesId,
                sessionId
            )
        }
    }

    override suspend fun getRatedSeries(
        userId: Int,
        page: Int
    ): ApiResponse<RatedSeriesDto> {
        val sessionId = userRepository.getSessionId()
        return handleApi {
            seriesService.getRatedSeries(
                userId,
                sessionId,
                page
            )
        }
    }

    override suspend fun getUserRatingForSeries(seriesId: Int): UserRatingResponse {
        val sessionId = userRepository.getSessionId()
        return handleApi {
            seriesService.getUserRatingForSeries(
                seriesId,
                sessionId
            )
        }
    }

    override suspend fun getLatestSeasons(): SeriesDetailDto =
        handleApi {
            seriesService.getLatestSeasons()
        }

    override suspend fun getListOfSeries(id: Int, page: Int): ApiResponse<SeriesDto> =
        handleApi {
            seriesService.getListOfSeries(
                id,
                page
            )
        }

    override suspend fun getSeriesReviews(id: Int, page: Int): ApiResponse<ReviewDto> =
        handleApi {
            seriesService.getSeriesReviews(id, page)
        }

    override suspend fun getSeriesRecommendations(
        id: Int,
        page: Int
    ): ApiResponse<SeriesDto> =
        handleApi {
            seriesService.getSeriesRecommendations(id, page)
        }

    override suspend fun getSeriesByGenreId(genreId: Int, page: Int): ApiResponse<SeriesDto> =
        handleApi {
            seriesService.getSeriesByGenreId(genreId, page)
        }

    override suspend fun getSeriesCredits(seriesId: Int) =
        handleApi {
            seriesService.getSeriesCredits(seriesId)
        }

    override suspend fun getSeriesTrailers(seriesId: Int): MediaTrailersDto =
        handleApi {
            seriesService.getSeriesTrailers(seriesId)
        }

    override suspend fun getTopRatedTVSeries(page: Int): ApiResponse<SeriesDto> =
        handleApi {
            seriesService.getTopRatedTVSeries(page)
        }
}