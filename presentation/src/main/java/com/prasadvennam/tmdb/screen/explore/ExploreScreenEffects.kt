package com.prasadvennam.tmdb.screen.explore

import com.prasadvennam.domain.model.Genre
import com.prasadvennam.tmdb.utlis.ViewMode

sealed class ExploreScreenEffects {
    data class GenreSelected(val genre: Genre) : ExploreScreenEffects()
    data class ViewModeChanged(val viewMode: ViewMode) : ExploreScreenEffects()
    data class MovieClicked(val movieId: Int) : ExploreScreenEffects()
    data class SeriesClicked(val seriesId: Int) : ExploreScreenEffects()
    data class TabSelected(val tab: ExploreTabsPages) : ExploreScreenEffects()
    object RefreshRequested : ExploreScreenEffects()
    object LoadData : ExploreScreenEffects()
    data class ActorClicked(val actorId: Int) : ExploreScreenEffects()
}