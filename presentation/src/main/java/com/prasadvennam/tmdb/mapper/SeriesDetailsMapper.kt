package com.prasadvennam.tmdb.mapper

import com.prasadvennam.tmdb.common_ui_state.CrewUiState
import com.prasadvennam.tmdb.common_ui_state.MediaItemUiState
import com.prasadvennam.tmdb.screen.details.series_details.SeasonUiState
import com.prasadvennam.tmdb.screen.details.series_details.SeriesDetailsUiState

import com.prasadvennam.domain.model.Series
import com.prasadvennam.domain.model.Series.Creator
import com.prasadvennam.domain.model.Series.Season

fun Series.toUi() = SeriesDetailsUiState(
    id = id,
    title = title,
    overview = overview,
    trailerPath = trailerPath,
    rating = String.format("%.1f", rating.toDouble()),
    genre = genres.joinToString(", ") { it.name },
    releaseDate = releaseDate,
    posterPath = posterPath,
    numberOfSeasons = numberOfSeasons,
    numberOfEpisodes = numberOfEpisodes,
    seasons = seasons.map { it.toUi() },
    creators = creators.map { it.toUi() }
)

fun Season.toUi() = SeasonUiState(
    id = id,
    title = name,
    airDate = airDate,
    episodeCount = episodeCount,
    posterPath = posterPath,
    overview = overview,
    rate = rate
)

fun Creator.toUi() = CrewUiState(
    id = id,
    name = name,
    job = "Creator"
)

fun Series.toMediaItemUi() =
    MediaItemUiState(
        id = id,
        title = title,
        posterPath = posterPath,
        rating = rating,
        genres = genres.map { it.name },
        releaseDate = releaseDate,
        backdropPath = backdropPath,
        mediaType = MediaItemUiState.MediaType.Series,
    )