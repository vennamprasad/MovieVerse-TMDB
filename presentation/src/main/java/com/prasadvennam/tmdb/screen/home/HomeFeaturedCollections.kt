package com.prasadvennam.tmdb.screen.home

import com.prasadvennam.tmdb.presentation.R

enum class HomeFeaturedCollections(val title: Int, val image: Int, val genreId: Int) {
    HORROR(
        title = R.string.late_night_thrills,
        image = R.drawable.movieverse,
        genreId = 27
    ),
    SCIENCE_FICTION(
        title = R.string.mind_bending_stories,
        image = R.drawable.movieverse,
        genreId = 878
    ),
    DRAMA(
        title = R.string.cinematic_masterpieces,
        image = R.drawable.movieverse,
        genreId = 18
    ),
    FAMILY(
        title = R.string.family_night_picks,
        image = R.drawable.movieverse,
        genreId = 10751
    ),
    HISTORY(
        title = R.string.based_on_true_events,
        image = R.drawable.movieverse,
        genreId = 36
    ),
    COMEDY(
        title = R.string.feel_good_favorites,
        image = R.drawable.movieverse,
        genreId = 35
    )
}