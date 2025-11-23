package com.prasadvennam.tmdb.screen.actor_gallery

object ActorGalleryEffectHandler {
    fun handleEffect(
        effect: ActorGalleryEffect,
        navigateBack: () -> Unit,
        ) {
        when (effect) {
            ActorGalleryEffect.NavigateBack -> {
                navigateBack()
            }
        }
    }
}