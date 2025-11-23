package com.prasadvennam.tmdb.screen.see_more

import com.prasadvennam.tmdb.screen.explore.ExploreScreenState.GenreUiState
import com.prasadvennam.tmdb.utlis.ViewMode

data class SeeMoreUiState(
    val title: Int = 0,
    val isLoading: Boolean = false,
    val isContentEmpty: Boolean = false,
    val shouldShowError: Boolean = false,
    val viewMode: ViewMode = ViewMode.GRID,
    val enableBlur: String = "high",
    val moviesGenres: List<GenreUiState> = listOf(),
    val seriesGenres: List<GenreUiState> = listOf()
)
