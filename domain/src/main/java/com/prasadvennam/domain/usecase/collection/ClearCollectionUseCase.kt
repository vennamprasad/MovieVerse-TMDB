package com.prasadvennam.domain.usecase.collection

import com.prasadvennam.domain.repository.CollectionsRepository
import javax.inject.Inject

class ClearCollectionUseCase @Inject constructor(
    private val collectionsRepository: CollectionsRepository
) {
    suspend operator fun invoke(
        collectionId: Int
    ) = collectionsRepository.clearCollection(collectionId = collectionId)
}