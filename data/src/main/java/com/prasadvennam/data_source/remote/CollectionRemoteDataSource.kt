package com.prasadvennam.data_source.remote

import com.prasadvennam.remote.dto.collection.response.AddCollectionDto
import com.prasadvennam.remote.dto.collection.request.AddMediaItemToCollectionRequestDto
import com.prasadvennam.remote.dto.collection.response.CollectionDto
import com.prasadvennam.remote.dto.collection.request.CreateCollectionRequestDto
import com.prasadvennam.remote.dto.media_item.movie.MovieDto
import com.prasadvennam.utils.ApiResponse

interface CollectionRemoteDataSource {
    suspend fun getMyCollections(
        accountId: String,
        sessionId: String,
        page: Int
    ): ApiResponse<CollectionDto>

    suspend fun addNewCollection(
        collection: CreateCollectionRequestDto,
        sessionId: String
    ): AddCollectionDto

    suspend fun addMediaItemToCollection(
        item: AddMediaItemToCollectionRequestDto,
        collectionId: Int,
        sessionId: String
    ): ApiResponse<Unit>

    suspend fun getCollectionDetails(
        collectionId: Int,
        sessionId: String,
        page: Int
    ): ApiResponse<MovieDto>

    suspend fun deleteMediaItemFromCollection(
        item: AddMediaItemToCollectionRequestDto,
        collectionId: Int,
        sessionId: String
    ): ApiResponse<Unit>

    suspend fun clearCollection(
        collectionId: Int,
        sessionId: String
    ): ApiResponse<Unit>
}