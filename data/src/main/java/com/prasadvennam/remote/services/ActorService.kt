package com.prasadvennam.remote.services

import com.prasadvennam.remote.dto.actor.ActorBestOfMoviesDto
import com.prasadvennam.remote.dto.actor.ActorImagesDto
import com.prasadvennam.remote.dto.actor.ActorSocialMediaDto
import com.prasadvennam.remote.dto.actor.ActorDetailsDto
import com.prasadvennam.utils.ACTOR
import com.prasadvennam.utils.EXTERNAL_IDS
import com.prasadvennam.utils.IMAGES
import com.prasadvennam.utils.MOVIE_CREDITS
import retrofit2.http.*
import retrofit2.Response

interface ActorService {

    @GET("$ACTOR{actorId}")
    suspend fun getActorDetails(
        @Path("actorId") id: Int
    ): Response<ActorDetailsDto>

    @GET("$ACTOR{actorId}$IMAGES")
    suspend fun getActorGallery(
        @Path("actorId") id: Int
    ): Response<ActorImagesDto>

    @GET("$ACTOR{actorId}$MOVIE_CREDITS")
    suspend fun getActorBestMovies(
        @Path("actorId") id: Int
    ): Response<ActorBestOfMoviesDto>

    @GET("$ACTOR{actorId}$EXTERNAL_IDS")
    suspend fun getActorSocialMedia(
        @Path("actorId") id: Int
    ): Response<ActorSocialMediaDto>
}
