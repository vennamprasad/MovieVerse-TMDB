package com.prasadvennam.tmdb.mapper

import com.prasadvennam.tmdb.common_ui_state.MediaItemUiState
import com.prasadvennam.tmdb.screen.explore.ExploreScreenState.GenreUiState
import com.prasadvennam.domain.model.Movie
import kotlin.collections.map

fun List<Movie>.toUi(
    genresList: List<GenreUiState>
): List<MediaItemUiState> {
    return this.map { movie ->
        MediaItemUiState(
            id = movie.id,
            title = movie.title,
            posterPath = movie.posterUrl,
            rating = movie.rating,
            genres = movie.genreIds.map { genresList.first { genre -> genre.id == it }.name },
            releaseDate = movie.releaseDate,
            mediaType = MediaItemUiState.MediaType.Movie,
            backdropPath = movie.backdropUrl
        )
    }
}