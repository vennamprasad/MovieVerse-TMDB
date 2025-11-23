package com.prasadvennam.tmdb.screen.on_boarding

import androidx.lifecycle.viewModelScope
import com.prasadvennam.domain.repository.OnboardingRepository
import com.prasadvennam.domain.repository.auth.UserRepository
import com.prasadvennam.tmdb.base.BaseViewModel
import com.prasadvennam.tmdb.presentation.R
import com.prasadvennam.tmdb.utlis.StringValue
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val onboardingRepository: OnboardingRepository
) :
    BaseViewModel<OnBoardingState, OnBoardingScreenEvents>(OnBoardingState()),
    OnBoardingInteractionListener {

    init {
        getPages()
    }

    private fun getPages() {
        updateState {
            it.copy(
                pages =
                    listOf(
                        PageUiState(
                            imageResId = R.drawable.colored_star_struck,
                            title = StringValue.StringResource(R.string.welcome_to_your_movie_universe),
                            description = StringValue.StringResource(R.string.discover_track_and_rate_your_favorite_movies_series)
                        ),
                        PageUiState(
                            imageResId = R.drawable.colored_star_struck,
                            title = StringValue.StringResource(R.string.track_everything),
                            description = StringValue.StringResource(R.string.your_watchlist_your_ratings_all_in_one_place)
                        ),
                        PageUiState(
                            imageResId = R.drawable.colored_star_struck,
                            title = StringValue.StringResource(R.string.personalized_recommendations),
                            description = StringValue.StringResource(R.string.answer_fun_questions_to_get_handpicked_recommendations)
                        )
                    )
            )
        }
    }

    override fun onPageChanged(pageIndex: Int) {
        updateState { it.copy(currentPage = pageIndex) }
    }

    override fun onClickPreviousButton() {
        val prev = uiState.value.currentPage - 1
        if (prev >= 0) {
            updateState { it.copy(currentPage = prev) }
        }
    }

    override fun onClickNextButton() {
        val next = uiState.value.currentPage + 1
        if (next < uiState.value.pages.size) {
            updateState { it.copy(currentPage = next) }
        }
    }

    override fun onClickGetStartedButton() {
        viewModelScope.launch {
            onboardingRepository.setOnBoardingCompleted()
            sendEvent(OnBoardingScreenEvents.NavigateToLoginScreen)
        }
    }
}