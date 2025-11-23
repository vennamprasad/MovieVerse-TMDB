package com.prasadvennam.tmdb.screen.cast_detials.components

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.prasadvennam.tmdb.component.MediaPosterCard
import com.prasadvennam.tmdb.component.MovieListSection
import com.prasadvennam.tmdb.screen.cast_detials.CastDetailsInteractionListener
import com.prasadvennam.tmdb.screen.cast_detials.CastDetailsUiState
import com.prasadvennam.tmdb.utlis.ViewMode
import com.prasadvennam.tmdb.presentation.R

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun ActorMoviesSection(
    uiState: CastDetailsUiState,
    interactionListener: CastDetailsInteractionListener,
    modifier: Modifier = Modifier
) {
    if (uiState.movies.isNotEmpty()) {
        MovieListSection(
            title = stringResource(
                R.string.best_of,
                uiState.actor?.name.orEmpty()
            ),
            mediaItems = uiState.movies.take(10),
            onClickShowMore = interactionListener::onShowMoreMovies,
            onClickPoster = interactionListener::onMovieClick,
            movieCardContent = { movie, cardModifier, onMovieClick ->
                MediaPosterCard(
                    mediaItem = movie,
                    viewMode = ViewMode.GRID,
                    showRating = true,
                    enableBlur = uiState.enableBlur,
                    onMediaItemClick = { onMovieClick(movie) },
                    showTitle = true,
                    modifier = cardModifier,
                )
            },
            modifier = modifier
        )
    }
}

