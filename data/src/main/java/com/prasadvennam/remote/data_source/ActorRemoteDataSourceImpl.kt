package com.prasadvennam.remote.data_source

import com.prasadvennam.data_source.remote.ActorRemoteDataSource
import com.prasadvennam.remote.dto.actor.ActorBestOfMoviesDto
import com.prasadvennam.remote.dto.actor.ActorImagesDto
import com.prasadvennam.remote.dto.actor.ActorSocialMediaDto
import com.prasadvennam.remote.dto.actor.ActorDetailsDto
import com.prasadvennam.remote.services.ActorService
import com.prasadvennam.utils.handleApi
import javax.inject.Inject

class ActorRemoteDataSourceImpl @Inject constructor(private val actorService: ActorService) :
    ActorRemoteDataSource {
    override suspend fun getActorDetails(id: Int): ActorDetailsDto =
        handleApi {
            actorService.getActorDetails(id)
        }


    override suspend fun getActorGallery(id: Int): ActorImagesDto =
        handleApi {
            actorService.getActorGallery(id)
        }

    override suspend fun getActorBestMovies(id: Int): ActorBestOfMoviesDto =
        handleApi {
            actorService.getActorBestMovies(id)
        }

    override suspend fun getActorSocialMedia(id: Int): ActorSocialMediaDto =
        handleApi {
            actorService.getActorSocialMedia(id)
        }
}