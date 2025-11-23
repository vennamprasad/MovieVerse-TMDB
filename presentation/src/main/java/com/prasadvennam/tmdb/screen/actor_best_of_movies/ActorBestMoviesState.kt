package com.prasadvennam.tmdb.screen.actor_best_of_movies

import com.prasadvennam.tmdb.common_ui_state.MediaItemUiState
import com.prasadvennam.tmdb.screen.explore.ExploreScreenState.GenreUiState
import com.prasadvennam.tmdb.utlis.ViewMode

data class ActorBestMoviesState(
    val actorId: Int = 0,
    val actorName: String = "",
    val isLoading: Boolean = false,
    val error: Int? = null,
    val viewMode: ViewMode = ViewMode.GRID,
    val movies: List<MediaItemUiState> = emptyList(),
    val moviesGenres: List<GenreUiState> = emptyList(),
    val enableBlur: String = "high"
)