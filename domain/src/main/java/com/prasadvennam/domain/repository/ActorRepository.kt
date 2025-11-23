package com.prasadvennam.domain.repository

import com.prasadvennam.domain.model.Actor
import com.prasadvennam.domain.model.Movie

interface ActorRepository {
    suspend fun getActorDetails(actorId: Int): Actor
    suspend fun getActorGalleryUrl(actorId: Int): List<String>
    suspend fun getBestOfMovies(actorId: Int): List<Movie>
}