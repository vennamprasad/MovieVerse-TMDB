package com.prasadvennam.data_source.remote

import com.prasadvennam.remote.dto.actor.ActorBestOfMoviesDto
import com.prasadvennam.remote.dto.actor.ActorImagesDto
import com.prasadvennam.remote.dto.actor.ActorSocialMediaDto
import com.prasadvennam.remote.dto.actor.ActorDetailsDto

interface ActorRemoteDataSource {
    suspend fun getActorDetails(id: Int): ActorDetailsDto
    suspend fun getActorGallery(id: Int): ActorImagesDto
    suspend fun getActorBestMovies(id: Int): ActorBestOfMoviesDto
    suspend fun getActorSocialMedia(id: Int): ActorSocialMediaDto
}