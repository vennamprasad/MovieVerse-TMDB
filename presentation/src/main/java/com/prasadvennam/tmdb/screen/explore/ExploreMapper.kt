package com.prasadvennam.tmdb.screen.explore

import com.prasadvennam.tmdb.common_ui_state.MediaItemUiState
import com.prasadvennam.tmdb.common_ui_state.MediaItemUiState.MediaType
import com.prasadvennam.tmdb.screen.explore.ExploreScreenState.ActorUiState
import com.prasadvennam.tmdb.screen.explore.ExploreScreenState.GenreUiState
import com.prasadvennam.domain.model.Actor
import com.prasadvennam.domain.model.Genre
import com.prasadvennam.domain.model.Movie
import com.prasadvennam.domain.model.Series

const val YYYY_MMM_DD = "yyyy, MMM dd"

fun Movie.toUi(genresList: List<GenreUiState> = listOf()): MediaItemUiState =
    MediaItemUiState(
        id = id,
        title = title,
        posterPath = posterUrl,
        rating = rating,
        genres = if (genresList.isEmpty()) emptyList() else
            genreIds.mapNotNull { id ->
            genresList.firstOrNull { genre -> genre.id == id }?.name
        },
        releaseDate = releaseDate,
        mediaType = MediaType.Movie,
        backdropPath = backdropUrl
    )

fun Series.toUi(genresList: List<GenreUiState> = listOf()): MediaItemUiState =
    MediaItemUiState(
        id = id,
        title = title,
        posterPath = posterPath,
        rating = rating,
        genres = if (genresList.isEmpty()) emptyList() else
            genreIds.mapNotNull { id ->
                genresList.firstOrNull { genre -> genre.id == id }?.name
            },
        releaseDate = releaseDate,
        mediaType = MediaType.Series,
        backdropPath = this.backdropPath
    )

fun Actor.toUi(): ActorUiState =
    ActorUiState(
        title = name,
        profilePath = profileImg,
        id = id
    )

fun Genre.toUi() =
    GenreUiState(
        id = id,
        name = name
    )

fun ExploreTabsPages.toTitle(): String {
    return when (this) {
        ExploreTabsPages.MOVIES -> "Movies"
        ExploreTabsPages.SERIES -> "Series"
        ExploreTabsPages.ACTORS -> "Actors"
    }
}
