package com.prasadvennam.tmdb.screen.see_more

import com.prasadvennam.tmdb.utlis.ViewMode

interface SeeMoreInteractionListener {
    fun onRefresh()
    fun onMediaItemClicked(id: Int)
    fun onActorClick(id: Int)
    fun onNavigateBack()
    fun onViewModeChanged(viewMode: ViewMode)
}