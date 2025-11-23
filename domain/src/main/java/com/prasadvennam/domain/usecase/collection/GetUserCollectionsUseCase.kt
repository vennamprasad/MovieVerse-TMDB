package com.prasadvennam.domain.usecase.collection

import com.prasadvennam.domain.repository.CollectionsRepository
import javax.inject.Inject

class GetUserCollectionsUseCase @Inject constructor(
    private val collectionsRepository: CollectionsRepository
) {
    suspend operator fun invoke(page: Int) =
        collectionsRepository.getCollections(page)
}