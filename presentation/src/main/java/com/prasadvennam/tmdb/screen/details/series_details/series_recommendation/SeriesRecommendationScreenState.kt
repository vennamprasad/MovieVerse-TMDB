package com.prasadvennam.tmdb.screen.details.series_details.series_recommendation

import androidx.paging.PagingData
import com.prasadvennam.tmdb.common_ui_state.MediaItemUiState
import com.prasadvennam.tmdb.screen.explore.ExploreScreenState
import com.prasadvennam.tmdb.utlis.ViewMode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

data class SeriesRecommendationScreenState(
    val viewMode: ViewMode = ViewMode.GRID,
    val isLoading: Boolean = false,
    val error: Int? = null,
    val enableBlur: String = "high",
    val seriesGenre: List<ExploreScreenState.GenreUiState> = listOf(),
    val recommendation: Flow<PagingData<MediaItemUiState>> = flowOf()
)