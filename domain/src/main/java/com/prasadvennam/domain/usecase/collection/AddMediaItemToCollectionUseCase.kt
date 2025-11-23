package com.prasadvennam.domain.usecase.collection

import com.prasadvennam.domain.repository.CollectionsRepository
import javax.inject.Inject

class AddMediaItemToCollectionUseCase @Inject constructor(
    private val collectionsRepository: CollectionsRepository
) {
    suspend operator fun invoke(
        mediaItemId: Int,
        collectionId: Int
    ) = collectionsRepository.addMovieToCollection(
            mediaItemId = mediaItemId,
            collectionId = collectionId
        )
}