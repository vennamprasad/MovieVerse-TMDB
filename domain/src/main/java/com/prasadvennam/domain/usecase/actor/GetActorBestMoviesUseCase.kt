package com.prasadvennam.domain.usecase.actor

import com.prasadvennam.domain.model.Movie
import com.prasadvennam.domain.repository.ActorRepository
import javax.inject.Inject

class GetActorBestMoviesUseCase @Inject constructor(
    private val actorRepository: ActorRepository
) {
    suspend operator fun invoke(actorId: Int): List<Movie> =
        actorRepository.getBestOfMovies(actorId)
            .sortedByDescending { it.rating }
            .distinctBy { it.id }
}