package com.prasadvennam.tmdb.screen.actor_best_of_movies

import com.prasadvennam.tmdb.utlis.ViewMode

interface ActorBestMoviesInteractionListener {
    fun onRefresh()
    fun onViewModeChanged(viewMode: ViewMode)
    fun onMovieClick(movieId: Int)
    fun backButtonClick()
}