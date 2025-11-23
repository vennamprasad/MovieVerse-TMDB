package com.prasadvennam.tmdb.screen.collection_details

import com.prasadvennam.tmdb.common_ui_state.MediaItemUiState.MediaType

interface CollectionDetailsInteractionListener {
    fun onBackButtonClicked()
    fun onMediaItemClicked(mediaId: Int, mediaType: MediaType)
    fun onItemDeletedIconClicked(mediaId: Int, mediaType: MediaType)
    fun clearCollection()
    fun onTipCancelIconClicked()
    fun onRefresh()
    fun onStartCollectingClick()
}