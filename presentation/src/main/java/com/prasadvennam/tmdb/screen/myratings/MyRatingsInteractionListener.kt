package com.prasadvennam.tmdb.screen.myratings

import com.prasadvennam.tmdb.common_ui_state.MediaItemUiState
import com.prasadvennam.tmdb.screen.explore.ExploreTabsPages

interface MyRatingsInteractionListener {
    fun onTabSelected(tab: ExploreTabsPages)
    fun onMediaItemClicked(mediaItemUiState: MediaItemUiState)
    fun onNavigateBack()
    fun onRefresh()
    fun onEmptyStateButtonClicked()
    fun onTipCancelIconClicked()
}