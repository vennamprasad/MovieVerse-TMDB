package com.prasadvennam.tmdb.screen.myratings

import com.prasadvennam.tmdb.common_ui_state.MediaItemUiState
import com.prasadvennam.tmdb.screen.explore.ExploreScreenState.GenreUiState
import com.prasadvennam.tmdb.screen.explore.ExploreTabsPages

data class MyRatingsUiState(
    val selectedTab: ExploreTabsPages = ExploreTabsPages.MOVIES,
    val isLoading: Boolean = false,
    val shouldShowError: Boolean = false,
    val errorMessage: Int = 0,
    val ratedMediaItems: List<RatedMediaItem> = emptyList(),
    val movieGenres: List<GenreUiState> = emptyList(),
    val seriesGenres: List<GenreUiState> = emptyList(),
    val isContentEmpty: Boolean = false,
    val enableBlur: String = "high",
    val showTip: Boolean = true,
)

data class RatedMediaItem(
    val mediaItem: MediaItemUiState,
    val rating: Int
)