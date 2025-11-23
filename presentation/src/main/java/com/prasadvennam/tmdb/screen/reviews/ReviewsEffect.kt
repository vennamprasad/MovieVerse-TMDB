package com.prasadvennam.tmdb.screen.reviews

sealed class ReviewsEffect {
    data object NavigateBack : ReviewsEffect()
    data class ShowError(val message: String) : ReviewsEffect()
}

