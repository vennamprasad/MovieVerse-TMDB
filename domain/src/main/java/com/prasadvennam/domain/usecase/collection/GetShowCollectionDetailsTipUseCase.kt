package com.prasadvennam.domain.usecase.collection

import com.prasadvennam.domain.repository.CategoryTipsRepository
import javax.inject.Inject

class GetShowCollectionDetailsTipUseCase @Inject constructor(
    private val categoryTipsRepository: CategoryTipsRepository
) {
    suspend operator fun invoke() =
        categoryTipsRepository.showCategoryDetailsTip()
}