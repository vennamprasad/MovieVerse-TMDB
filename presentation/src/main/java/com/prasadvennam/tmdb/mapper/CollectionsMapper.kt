package com.prasadvennam.tmdb.mapper

import com.prasadvennam.tmdb.common_ui_state.CollectionUiState
import com.prasadvennam.domain.model.Collection

fun Collection.toCollectionUi() =
    CollectionUiState(
        id = id,
        title = name,
        numberOfItems = itemCount,
    )