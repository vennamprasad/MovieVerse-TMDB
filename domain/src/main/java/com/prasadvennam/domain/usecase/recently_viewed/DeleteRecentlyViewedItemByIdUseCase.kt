package com.prasadvennam.domain.usecase.recently_viewed

import com.prasadvennam.domain.repository.RecentlyViewedRepository
import javax.inject.Inject

class DeleteRecentlyViewedItemByIdUseCase @Inject constructor(
    private val repository: RecentlyViewedRepository
) {
    suspend operator fun invoke(
        id: Int
    ) = repository.deleteRecentlyViewedItemById(id = id)

}