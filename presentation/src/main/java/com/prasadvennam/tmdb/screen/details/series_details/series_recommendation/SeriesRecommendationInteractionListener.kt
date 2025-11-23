package com.prasadvennam.tmdb.screen.details.series_details.series_recommendation

import com.prasadvennam.tmdb.utlis.ViewMode

interface SeriesRecommendationInteractionListener {
    fun onSeriesClicked(seriesId: Int)
    fun onViewModeChanged(viewMode: ViewMode)
    fun onRetry()
}