package com.prasadvennam.tmdb.screen.collections

import com.prasadvennam.tmdb.common_ui_state.CollectionUiState

data class CollectionsBottomSheetScreenState(
    val isLoading: Boolean = false,
    val errorMessage: Int? = null,
    val showBottomSheet: Boolean = false,
    val collections: List<CollectionUiState> = emptyList(),
    val showProcessIndicator: Boolean = false,
    val isLoggedIn: Boolean? = null
)