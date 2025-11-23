package com.prasadvennam.domain.usecase.rating

import com.prasadvennam.domain.repository.RatingTipsRepository
import javax.inject.Inject

class CloseRatingTipUseCase @Inject constructor(
    private val ratingTipsRepository: RatingTipsRepository
) {
    suspend operator fun invoke() = ratingTipsRepository.closeRatingTip()
}