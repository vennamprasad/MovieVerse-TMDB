package com.prasadvennam.tmdb.screen.details.movie_details.recommendations

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.prasadvennam.tmdb.common_ui_state.MediaItemUiState
import com.prasadvennam.tmdb.component.ErrorContent
import com.prasadvennam.tmdb.component.MediaPosterCard
import com.prasadvennam.tmdb.component.NoInternetScreen
import com.prasadvennam.tmdb.designSystem.component.app_bar.MovieAppBar
import com.prasadvennam.tmdb.designSystem.component.indicator.MovieCircularProgressBar
import com.prasadvennam.tmdb.designSystem.component.wrapper.MovieScaffold
import com.prasadvennam.tmdb.screen.explore.component.ViewModeToggleButton
import com.prasadvennam.tmdb.utlis.ViewMode
import com.prasadvennam.tmdb.presentation.R

@Composable
fun RecommendationMoviesScreen(
    modifier: Modifier = Modifier,
    viewModel: RecommendationsMoviesViewModel = hiltViewModel(),
    navigateBack: () -> Unit,
    navigateToMovieDetails: (Int) -> Unit,

    ) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val recommendations = uiState.recommendation.collectAsLazyPagingItems()

    LaunchedEffect(viewModel) {
        viewModel.uiEffect.collect { event ->
            when(event){
                RecommendationMoviesEffect.NavigateBack -> {
                    navigateBack()
                }

                is RecommendationMoviesEffect.MovieClicked -> {
                    navigateToMovieDetails(
                        event.movieId,
                    )
                }
            }
        }
    }
    RecommendationMoviesContent(
        uiState,
        recommendations = recommendations,
        interactionListener = viewModel,
        modifier = modifier,
        title = uiState.movieTitle
    )
}


@SuppressLint("UnusedContentLambdaTargetStateParameter")
@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun RecommendationMoviesContent(
    uiState: RecommendationsMoviesState,
    recommendations: LazyPagingItems<MediaItemUiState>,
    interactionListener: RecommendationsMoviesInteractionListener,
    modifier: Modifier = Modifier,
    title: String
) {
    MovieScaffold(
        movieAppBar = {
            MovieAppBar(
                caption = stringResource(R.string.because_you_watched),
                title = title,
                backButtonClick = interactionListener::backButtonClick,
            )
        }
    ) {
        SharedTransitionLayout {
            AnimatedContent(
                targetState = uiState.viewMode,
                transitionSpec = {
                    fadeIn() togetherWith fadeOut()
                },
                label = "view_mode_transition"
            ) {
                Box(modifier = modifier.fillMaxSize()) {
                    if (uiState.isLoading){
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            MovieCircularProgressBar()
                        }
                    }
                    else if (uiState.error != null){
                        ErrorContent(
                            errorMessage = uiState.error,
                            onRetry = {
                                interactionListener.onRetry()
                                recommendations.retry()
                            },
                        )
                    }
                    else{
                        if (recommendations.loadState.refresh is LoadState.Loading){
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                MovieCircularProgressBar()
                            }
                        }
                        else if(recommendations.loadState.refresh is LoadState.Error){
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                NoInternetScreen(onRetry = { recommendations.retry() })
                            }
                        }
                        else{
                            Column(modifier = Modifier.fillMaxSize()) {
                                LazyVerticalGrid(
                                    columns = if (uiState.viewMode == ViewMode.GRID)
                                        GridCells.Adaptive(minSize = 150.dp)
                                    else
                                        GridCells.Fixed(1),
                                    contentPadding = PaddingValues(
                                        vertical = 16.dp,
                                        horizontal = 16.dp
                                    ),
                                    verticalArrangement = Arrangement.spacedBy(16.dp),
                                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                                    modifier = Modifier.fillMaxSize()
                                ) {
                                    items(recommendations.itemCount)
                                    { index ->
                                        val recommendation = recommendations[index]
                                        if (recommendation != null) {
                                            MediaPosterCard(
                                                mediaItem = recommendation,
                                                viewMode = uiState.viewMode,
                                                onMediaItemClick = interactionListener::onMovieClick,
                                                enableBlur = uiState.enableBlur,
                                                sharedTransitionScope = this@SharedTransitionLayout,
                                                animatedVisibilityScope = this@AnimatedContent
                                            )
                                        }
                                    }
                                    if (recommendations.loadState.append is LoadState.Loading) {
                                        item(span = {GridItemSpan(maxLineSpan)}){
                                            Box(
                                                modifier = Modifier.height(214.dp),
                                                contentAlignment = Alignment.Center
                                            ) {
                                                MovieCircularProgressBar(Modifier)
                                            }
                                        }
                                    }
                                    if (recommendations.loadState.append is LoadState.Error) {
                                        item(span = { GridItemSpan(maxLineSpan) }) {
                                            NoInternetScreen(
                                                modifier = Modifier.align(Alignment.CenterHorizontally),
                                                onRetry = { recommendations.retry() }
                                            )
                                        }
                                    }
                                }
                            }
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
    }
}