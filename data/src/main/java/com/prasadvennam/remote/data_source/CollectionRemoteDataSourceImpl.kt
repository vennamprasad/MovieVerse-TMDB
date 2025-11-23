package com.prasadvennam.remote.data_source

import com.prasadvennam.data_source.remote.CollectionRemoteDataSource
import com.prasadvennam.remote.dto.collection.request.AddMediaItemToCollectionRequestDto
import com.prasadvennam.remote.dto.collection.response.CollectionDto
import com.prasadvennam.remote.dto.collection.request.CreateCollectionRequestDto
import com.prasadvennam.remote.dto.media_item.movie.MovieDto
import com.prasadvennam.remote.services.CollectionsService
import com.prasadvennam.utils.ApiResponse
import com.prasadvennam.utils.handleApi
import javax.inject.Inject

class CollectionRemoteDataSourceImpl  @Inject constructor(
    private val collectionsService: CollectionsService
) : CollectionRemoteDataSource {
    override suspend fun getMyCollections(
        accountId: String,
        sessionId: String,
        page: Int
    ): ApiResponse<CollectionDto> = handleApi {
        collectionsService.getMyCollections(
            accountId,
            page,
            sessionId
        )
    }

    override suspend fun addNewCollection(
        collection: CreateCollectionRequestDto,
        sessionId: String
    ) = handleApi {
        collectionsService.addNewCollection(
            collection,
            sessionId
        )
    }

    override suspend fun addMediaItemToCollection(
        item: AddMediaItemToCollectionRequestDto,
        collectionId: Int,
        sessionId: String
    ): ApiResponse<Unit> = handleApi {
        collectionsService.addMediaItemToCollection(
            item,
            collectionId,
            sessionId
        )
    }

    override suspend fun getCollectionDetails(
        collectionId: Int,
        sessionId: String,
        page:Int
    ): ApiResponse<MovieDto> = handleApi {
        collectionsService.getCollectionDetails(
            collectionId,
            sessionId,
            page
        )
    }

    override suspend fun deleteMediaItemFromCollection(
        item: AddMediaItemToCollectionRequestDto,
        collectionId: Int,
        sessionId: String
    ) = handleApi {
        collectionsService.deleteMediaItemFromCollection(
            item,
            collectionId,
            sessionId
        )
    }

    override suspend fun clearCollection(
        collectionId: Int,
        sessionId: String
    ) = handleApi {
        collectionsService.clearCollection(
            collectionId,
            sessionId
        )
    }
}