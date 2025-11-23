package com.prasadvennam.tmdb.screen.details.movie_details.recommendations

import com.prasadvennam.tmdb.utlis.ViewMode

interface RecommendationsMoviesInteractionListener {
    fun onViewModeChanged(viewMode: ViewMode)
    fun onMovieClick(movieId: Int)
    fun backButtonClick()
    fun onRetry()
}