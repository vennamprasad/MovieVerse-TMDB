package com.prasadvennam.mapper

import com.prasadvennam.domain.model.Series
import com.prasadvennam.domain.usecase.rating.GetRatedSeriesUseCase.RatedSeriesResult
import com.prasadvennam.remote.dto.rating.response.RatedSeriesDto
import com.prasadvennam.utils.IMAGES_URL
import kotlinx.datetime.toLocalDate

fun RatedSeriesDto.toOutputResult(): RatedSeriesResult? {
    val id = this.id ?: return null
    val name = this.name ?: return null
    val backdropPath = this.backdropPath ?: ""
    val releaseDate = try {
        this.firstAirDate?.toLocalDate() ?: return null
    } catch (_: Exception) {
        return null
    }
    val genreIds = this.genreIds?.filterNotNull() ?: emptyList()
    val overview = this.overview ?: ""
    val posterPath = (IMAGES_URL + this.posterPath)
    val rating = this.rating?.toFloat() ?: return null

    return RatedSeriesResult(
        series = Series(
            id = id,
            title = name,
            overview = overview,
            posterPath = posterPath,
            trailerPath = "",
            backdropPath = backdropPath,
            genres = emptyList(),
            genreIds = genreIds,
            rating = this.voteAverage?.toFloat() ?: 0f,
            voteCount = this.voteCount ?: 0,
            releaseDate = releaseDate,
            creators = emptyList(),
            numberOfSeasons = 0,
            numberOfEpisodes = 0,
            seasons = emptyList(),
            type = ""
        ),
        rating = rating
    )
}