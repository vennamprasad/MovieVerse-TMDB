package com.prasadvennam.tmdb.screen.history

import com.prasadvennam.tmdb.common_ui_state.MediaItemUiState

interface HistoryInteractionListener {
    fun onBackPressed()
    fun onMediaItemClicked(mediaItemUiState: MediaItemUiState)
    fun onTipCancelIconClicked()
    fun onItemDeletedIconClicked(mediaId: Int)
    fun onFindToSomethingToWatchButton()
    fun onRetry()
}