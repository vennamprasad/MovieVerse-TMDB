package com.prasadvennam.tmdb.mapper

import com.prasadvennam.tmdb.common_ui_state.CollectionUiState
import com.prasadvennam.tmdb.common_ui_state.MediaItemUiState
import com.prasadvennam.tmdb.screen.home.HomeScreenState
import com.prasadvennam.domain.model.Collection
import com.prasadvennam.domain.model.Movie
import com.prasadvennam.domain.model.Series

fun List<Movie>.toUi(
    genresList: List<HomeScreenState.GenreUi> = listOf()
): List<MediaItemUiState> {
    return this.map { movie ->
        MediaItemUiState(
            id = movie.id,
            title = movie.title,
            posterPath = movie.posterUrl,
            backdropPath = movie.backdropUrl,
            rating = movie.rating,
            mediaType = MediaItemUiState.MediaType.Movie,
            genres = if (genresList.isEmpty()) listOf() else
                movie.genreIds.map { genresList.first { genre -> genre.id == it }.name },
            releaseDate = movie.releaseDate,
        )
    }
}

fun List<Series>.toUi(
): List<MediaItemUiState> {
    return this.map { series ->
        MediaItemUiState(
            id = series.id,
            title = series.title,
            posterPath = series.posterPath,
            rating = series.rating,
            genres = emptyList(),
            releaseDate = series.releaseDate,
            mediaType = MediaItemUiState.MediaType.Series,
            backdropPath = series.backdropPath,
        )
    }
}

fun Collection.toUi() = CollectionUiState(
    id = id,
    title = name,
    numberOfItems = itemCount,
    isLoading = false
)

