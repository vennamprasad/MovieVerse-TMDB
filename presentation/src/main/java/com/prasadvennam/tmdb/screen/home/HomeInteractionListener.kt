package com.prasadvennam.tmdb.screen.home

import com.prasadvennam.tmdb.common_ui_state.MediaItemUiState

interface HomeInteractionListener {
    fun onMediaItemClicked(mediaItemUiState: MediaItemUiState)
    fun onSeeAllClick(type: HomeFeaturedItems)
    fun onCollectionsShowMoreClick()
    fun onCollectionClick(collectionId: Int, collectionName: String)
    fun onWatchSuggestionClick()
    fun onBrowseSuggestionClick()
    fun onRefresh()
    fun onSeeMoreRecentlyViewedClicked()
    fun onFeaturedCollectionClick(genreId: Int)
}