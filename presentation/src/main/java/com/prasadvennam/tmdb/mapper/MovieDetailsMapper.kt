package com.prasadvennam.tmdb.mapper

import com.prasadvennam.tmdb.common_ui_state.CastUiState
import com.prasadvennam.tmdb.common_ui_state.CrewUiState
import com.prasadvennam.tmdb.common_ui_state.DurationUiState
import com.prasadvennam.tmdb.common_ui_state.MediaItemUiState
import com.prasadvennam.tmdb.common_ui_state.ReviewUiState
import com.prasadvennam.tmdb.screen.details.movie_details.MovieScreenState
import com.prasadvennam.domain.model.CreditsInfo
import com.prasadvennam.domain.model.Movie
import com.prasadvennam.domain.model.Review

fun Movie.toUi(): MovieScreenState.MovieDetailsUiState =
    MovieScreenState.MovieDetailsUiState(
        id = id,
        title = title,
        posterUrl = posterUrl,
        trailerUrl = trailerUrl,
        rating = String.format("%.1f", rating.toDouble()),
//            (rating * 10).toInt() / 10.0,
        genres = genres,
        releaseDate = releaseDate,
        description = overview,
        duration = duration.toUi()
    )

fun Movie.Duration.toUi(): DurationUiState =
    DurationUiState(
        hours = hours,
        minutes = minutes
    )


fun Review.toUi(): ReviewUiState =
    ReviewUiState(
        id = id,
        username = username,
        name = author,
        userImageUrl = avatarPath,
        rate = rating,
        reviewContent = content,
        date = createdAt
    )

fun CreditsInfo.CastInfo.toUi() = CastUiState(
    id = id,
    originalName = originalName,
    characterName = characterName,
    profileImage = profileImg
)

fun CreditsInfo.CrewInfo.toUi() = CrewUiState(
    id = id,
    name = name,
    job = job,
)

fun Movie.toMediaItemUi() =
    MediaItemUiState(
        id = id,
        title = title,
        posterPath = posterUrl,
        rating = rating,
        genres = genres,
        releaseDate = releaseDate,
        backdropPath = backdropUrl,
        mediaType = MediaItemUiState.MediaType.Movie,
    )