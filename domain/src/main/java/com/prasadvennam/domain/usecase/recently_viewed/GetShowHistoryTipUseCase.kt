package com.prasadvennam.domain.usecase.recently_viewed

import com.prasadvennam.domain.repository.HistoryTipsRepository
import javax.inject.Inject

class GetShowHistoryTipUseCase @Inject constructor(
    private val historyTipsRepository: HistoryTipsRepository
) {
    suspend operator fun invoke() = historyTipsRepository.showHistoryTip()
}