package com.prasadvennam.domain.usecase.actor

import com.prasadvennam.domain.model.Actor
import com.prasadvennam.domain.repository.ActorRepository
import javax.inject.Inject

class GetActorDetailsUseCase @Inject constructor(
    private val actorRepository: ActorRepository
) {
    suspend operator fun invoke(actorId: Int): Actor =
        actorRepository.getActorDetails(actorId)
}