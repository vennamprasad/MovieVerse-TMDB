package com.prasadvennam.repository

import com.prasadvennam.data_source.remote.CollectionRemoteDataSource
import com.prasadvennam.domain.exception.MovieVerseException.AddMediaItemToCollectionException
import com.prasadvennam.domain.exception.MovieVerseException.ClearCollectionException
import com.prasadvennam.domain.exception.MovieVerseException.DeleteMediaItemFromCollectionException
import com.prasadvennam.domain.exception.MovieVerseException.NotAllowedUserException
import com.prasadvennam.domain.exception.MovieVerseException.NullException
import com.prasadvennam.domain.model.Collection
import com.prasadvennam.domain.model.Movie
import com.prasadvennam.domain.model.UserType
import com.prasadvennam.domain.repository.CollectionsRepository
import com.prasadvennam.domain.repository.auth.UserRepository
import com.prasadvennam.mapper.toDomain
import com.prasadvennam.remote.dto.collection.request.AddMediaItemToCollectionRequestDto
import com.prasadvennam.remote.dto.collection.request.CreateCollectionRequestDto
import com.prasadvennam.remote.dto.collection.response.toDomain
import javax.inject.Inject

class CollectionsRepositoryImpl @Inject constructor(
    private val collectionRemoteDataSource: CollectionRemoteDataSource,
    private val userRepository: UserRepository
) : CollectionsRepository {
    override suspend fun getCollections(page: Int): List<Collection> {
        val user = userRepository.getUser()
        val accountId = when (user) {
            is UserType.AuthenticatedUser -> user.id
            is UserType.GuestUser -> throw NotAllowedUserException
        }
        val response = collectionRemoteDataSource.getMyCollections(
            accountId = accountId,
            sessionId = userRepository.getSessionId(),
            page = page
        )
        return response.results?.map { it.toDomain() } ?: emptyList()
    }

    override suspend fun addNewCollection(
        collectionName: String,
        collectionDescription: String?
    ): Int {
        val collection =
            CreateCollectionRequestDto(name = collectionName, description = collectionDescription)
        val response = collectionRemoteDataSource.addNewCollection(
            collection = collection,
            sessionId = userRepository.getSessionId()
        )
        return response.listId ?: throw NullException
    }

    override suspend fun addMovieToCollection(
        mediaItemId: Int,
        collectionId: Int
    ) {
        val item = AddMediaItemToCollectionRequestDto(mediaId = mediaItemId)
        val response = collectionRemoteDataSource.addMediaItemToCollection(
            item = item,
            collectionId = collectionId,
            sessionId = userRepository.getSessionId()
        )
        if (response.success == false)
            throw AddMediaItemToCollectionException
    }

    override suspend fun deleteMovieFromCollection(
        mediaItemId: Int,
        collectionId: Int
    ) {
        val item = AddMediaItemToCollectionRequestDto(mediaId = mediaItemId)
        val response = collectionRemoteDataSource.deleteMediaItemFromCollection(
            item = item,
            collectionId = collectionId,
            sessionId = userRepository.getSessionId()
        )
        if (response.success == false)
            throw DeleteMediaItemFromCollectionException
    }

    override suspend fun getCollectionMovies(collectionId: Int, page: Int): List<Movie> {
        val response = collectionRemoteDataSource.getCollectionDetails(
            collectionId = collectionId,
            sessionId = userRepository.getSessionId(),
            page = page
        )
        return response.items?.map { it.toDomain() } ?: emptyList()
    }

    override suspend fun clearCollection(
        collectionId: Int
    ) {
        val response = collectionRemoteDataSource.clearCollection(
            collectionId = collectionId,
            sessionId = userRepository.getSessionId()
        )
        if (response.success == false)
            throw ClearCollectionException
    }
}