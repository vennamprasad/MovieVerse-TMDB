package com.prasadvennam.tmdb.screen.on_boarding

import com.prasadvennam.tmdb.utlis.StringValue

data class OnBoardingState(
    val currentPage: Int = 0,
    val pages: List<PageUiState> = emptyList(),
)

data class PageUiState(
    val imageResId: Int,
    val title: StringValue,
    val description: StringValue
)
