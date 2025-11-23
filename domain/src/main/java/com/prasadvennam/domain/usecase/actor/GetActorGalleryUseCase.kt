package com.prasadvennam.domain.usecase.actor

import com.prasadvennam.domain.repository.ActorRepository
import javax.inject.Inject

class GetActorGalleryUseCase @Inject constructor(
    private val actorRepository: ActorRepository
) {
    suspend operator fun invoke(actorId: Int): List<String> =
        actorRepository.getActorGalleryUrl(actorId)
}