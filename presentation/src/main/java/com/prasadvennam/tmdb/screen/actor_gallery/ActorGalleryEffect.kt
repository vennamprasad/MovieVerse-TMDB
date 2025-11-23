package com.prasadvennam.tmdb.screen.actor_gallery

sealed class ActorGalleryEffect {
    data object NavigateBack : ActorGalleryEffect()
}