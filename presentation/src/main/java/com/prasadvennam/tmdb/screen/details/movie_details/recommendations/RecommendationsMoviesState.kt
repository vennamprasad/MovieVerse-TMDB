package com.prasadvennam.tmdb.screen.details.movie_details.recommendations

import androidx.paging.PagingData
import com.prasadvennam.tmdb.common_ui_state.MediaItemUiState
import com.prasadvennam.tmdb.screen.explore.ExploreScreenState.GenreUiState
import com.prasadvennam.tmdb.utlis.ViewMode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

data class RecommendationsMoviesState(
    val movieId: Int = 0,
    val movieTitle: String = "",
    val isLoading: Boolean = false,
    val error: Int? = null,
    val viewMode: ViewMode = ViewMode.GRID,
    val movies: List<MediaItemUiState> = emptyList(),
    val enableBlur: String = "high",
    val moviesGenres: List<GenreUiState> = listOf(),
    val recommendation: Flow<PagingData<MediaItemUiState>> = flowOf()
)