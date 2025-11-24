package com.prasadvennam.tmdb.screen.home

import com.prasadvennam.tmdb.presentation.R

enum class HomeFeaturedCollections(
    val title: Int,
    val gradient: CollectionGradient,
    val genreId: Int
) {
    HORROR(
        title = R.string.late_night_thrills,
        gradient = CollectionGradients.horror,
        genreId = 27
    ),
    SCIENCE_FICTION(
        title = R.string.mind_bending_stories,
        gradient = CollectionGradients.scienceFiction,
        genreId = 878
    ),
    DRAMA(
        title = R.string.cinematic_masterpieces,
        gradient = CollectionGradients.drama,
        genreId = 18
    ),
    FAMILY(
        title = R.string.family_night_picks,
        gradient = CollectionGradients.family,
        genreId = 10751
    ),
    HISTORY(
        title = R.string.based_on_true_events,
        gradient = CollectionGradients.history,
        genreId = 36
    ),
    COMEDY(
        title = R.string.feel_good_favorites,
        gradient = CollectionGradients.comedy,
        genreId = 35
    )
}