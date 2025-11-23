package com.prasadvennam.tmdb.screen.reviews

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.prasadvennam.tmdb.base.BaseViewModel
import com.prasadvennam.tmdb.navigation.routes.ReviewsRoute
import com.prasadvennam.tmdb.paging.BasePagingSource
import com.prasadvennam.domain.model.Review
import com.prasadvennam.domain.usecase.review.GetReviewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ReviewsViewModel @Inject constructor(
    private val getReviewsUseCase: GetReviewsUseCase,
    savedStateHandle: SavedStateHandle
) : BaseViewModel<ReviewsScreenState, ReviewsEffect>(ReviewsScreenState()),
    ReviewsInteractionListener {
    private val id: Int = savedStateHandle.get<Int>(ReviewsRoute.ID) ?: 0
    private val isMovie: Boolean = savedStateHandle.get<Boolean>(ReviewsRoute.IS_MOVIE) == true

    fun getPagedReviews(): Flow<PagingData<Review>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = {
                BasePagingSource { page ->
                    getReviewsUseCase(id, page, isMovie)
                }
            }
        ).flow.cachedIn(viewModelScope)
    }

    override fun onBackPressed() {
        sendEvent(ReviewsEffect.NavigateBack)
    }

    override fun onRetry() {
        updateState { it.copy(errorMessage = null) }
        getPagedReviews()
    }
}