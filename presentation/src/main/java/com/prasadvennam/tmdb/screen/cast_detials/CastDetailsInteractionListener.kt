package com.prasadvennam.tmdb.screen.cast_detials

import com.prasadvennam.tmdb.common_ui_state.MediaItemUiState

interface CastDetailsInteractionListener {
    fun onBackPressed()
    fun onSocialMediaClick(platform: String, url: String)
    fun onRefresh()
    fun onMovieClick(movie: MediaItemUiState)
    fun onShowMoreMovies()
    fun onShowMoreGallery()
}