package com.prasadvennam.tmdb.screen.my_collections

import com.prasadvennam.tmdb.common_ui_state.CollectionUiState

data class MyCollectionsUiState(
    val errorMessage: Int? = null,
    val isLoading: Boolean = false,
    val collections: List<CollectionUiState> = emptyList(),
)
