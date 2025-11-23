package com.prasadvennam.tmdb.screen.details.series_details.series_recommendation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.prasadvennam.tmdb.base.BaseViewModel
import com.prasadvennam.tmdb.navigation.routes.SeriesRecommendationRoute
import com.prasadvennam.tmdb.paging.BasePagingSource
import com.prasadvennam.tmdb.screen.explore.toUi
import com.prasadvennam.tmdb.utlis.ViewMode
import com.prasadvennam.domain.service.blur.BlurProvider
import com.prasadvennam.domain.usecase.genre.GenreUseCase
import com.prasadvennam.domain.usecase.series.GetSeriesRecommendationsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SeriesRecommendationViewModel @Inject constructor(
    private val getSeriesRecommendationsUseCase: GetSeriesRecommendationsUseCase,
    private val genreUseCase: GenreUseCase,
    private val blurProvider: BlurProvider,
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<SeriesRecommendationScreenState, SeriesRecommendationEffects>(
    SeriesRecommendationScreenState()
),
    SeriesRecommendationInteractionListener {
    val seriesId = savedStateHandle.get<Int>(SeriesRecommendationRoute.SERIES_ID) ?: 0
    val seriesName = savedStateHandle.get<String>(SeriesRecommendationRoute.SERIES_NAME) ?: ""

    init {
        getMovieGenre()
        observeBlur()
    }

    private fun observeBlur() {
        viewModelScope.launch {
            blurProvider.blurFlow.collect { enableBlur ->
                updateState { it.copy(enableBlur = enableBlur) }
            }
        }
    }

    private fun getMovieGenre() {
        launchWithResult(
            action = { genreUseCase.getSeriesGenres(false) },
            onSuccess = { genres ->
                updateState {
                    it.copy(
                        seriesGenre = genres.map { genre -> genre.toUi() },
                        isLoading = false
                    )
                }
                getRecommendations(seriesId)
            },
            onError = { e ->
                updateState {
                    it.copy(
                        error = e,
                        isLoading = false,
                    )
                }
            },
            onStart = { updateState { it.copy(isLoading = true) } },
        )
    }

    private fun getRecommendations(id: Int) {
        updateState {
            it.copy(
                recommendation = Pager(
                    config = PagingConfig(pageSize = 20),
                    pagingSourceFactory = {
                        BasePagingSource { page ->
                            getSeriesRecommendationsUseCase(
                                id,
                                page
                            ).map { it.toUi(uiState.value.seriesGenre) }
                        }
                    }
                ).flow.cachedIn(viewModelScope)
            )
        }
    }

    override fun onSeriesClicked(seriesId: Int) {
        sendEvent(SeriesRecommendationEffects.NavigateToSeriesDetailsScreen(seriesId))
    }

    override fun onViewModeChanged(viewMode: ViewMode) {
        updateState { it.copy(viewMode = viewMode) }
    }

    override fun onRetry() {
        updateState { it.copy(error = null, isLoading = true) }
        getMovieGenre()
    }
}











