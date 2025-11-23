package com.prasadvennam.tmdb.screen.myratings

import com.prasadvennam.tmdb.screen.explore.ExploreScreenState.GenreUiState
import com.prasadvennam.tmdb.screen.explore.toUi
import com.prasadvennam.domain.usecase.rating.GetRatedMoviesUseCase.RatedMovieResult
import com.prasadvennam.domain.usecase.rating.GetRatedSeriesUseCase.RatedSeriesResult

fun RatedSeriesResult.toUi(genres : List<GenreUiState>): RatedMediaItem {
    return RatedMediaItem(
        mediaItem = this.series.toUi(genres),
        rating = this.rating.toInt()
    )
}

fun RatedMovieResult.toUi(genres : List<GenreUiState>): RatedMediaItem {
    return RatedMediaItem(
        mediaItem = this.movie.toUi(genres),
        rating = this.rating.toInt()
    )
}