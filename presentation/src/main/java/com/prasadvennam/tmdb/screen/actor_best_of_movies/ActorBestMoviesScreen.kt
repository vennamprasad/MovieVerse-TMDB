package com.prasadvennam.tmdb.screen.actor_best_of_movies

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.prasadvennam.tmdb.component.ErrorContent
import com.prasadvennam.tmdb.designSystem.component.app_bar.MovieAppBar
import com.prasadvennam.tmdb.designSystem.component.wrapper.MovieScaffold
import com.prasadvennam.tmdb.screen.actor_best_of_movies.component.LoadingContent
import com.prasadvennam.tmdb.screen.actor_best_of_movies.component.SuccessContent
import com.prasadvennam.tmdb.screen.explore.component.ViewModeToggleButton

@Composable
fun ActorBestMoviesScreen(
    modifier: Modifier = Modifier,
    navigateMovieDetails: (Int) -> Unit,
    navigateBack: () -> Unit = {},
    viewModel: ActorBestMoviesViewModel = hiltViewModel()

) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.uiEffect.collect { effect ->
            ActorBestMoviesEffectHandler.handleEffect(
                effect,
                navigateMovieDetails = navigateMovieDetails,
                navigateBack = navigateBack

            )
        }
    }

   ActorBestMoviesContent(
        uiState = uiState,
        interactionListener = viewModel,
        modifier = modifier,
        onNavigateBack = navigateBack,
    )
}

@Composable
private fun ActorBestMoviesContent(
    uiState: ActorBestMoviesState,
    interactionListener: ActorBestMoviesInteractionListener,
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    MovieScaffold (
        movieAppBar = {
            MovieAppBar(
                title = uiState.actorName,
                backButtonClick = onNavigateBack,
            )
        }
    ) {
        Box(modifier = modifier.fillMaxSize()) {
            when {
                uiState.isLoading -> {
                    LoadingContent(modifier = Modifier.align(Alignment.Center))
                }

                uiState.error != null -> {
                    ErrorContent(
                        errorMessage = uiState.error,
                        onRetry = interactionListener::onRefresh,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                else -> {
                    SuccessContent(
                        uiState = uiState,
                        interactionListener = interactionListener,
                        enableBlur = uiState.enableBlur,
                    )

                    ViewModeToggleButton(
                        selectedMode = uiState.viewMode,
                        onModeSelected = interactionListener::onViewModeChanged,
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}
