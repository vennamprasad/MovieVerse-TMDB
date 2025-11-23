package com.prasadvennam.remote.services

import com.prasadvennam.remote.dto.collection.response.AddCollectionDto
import com.prasadvennam.remote.dto.collection.request.AddMediaItemToCollectionRequestDto
import com.prasadvennam.remote.dto.collection.response.CollectionDto
import com.prasadvennam.remote.dto.collection.request.CreateCollectionRequestDto
import com.prasadvennam.remote.dto.media_item.movie.MovieDto
import com.prasadvennam.utils.ACCOUNT
import com.prasadvennam.utils.ADD_ITEM
import com.prasadvennam.utils.ApiResponse
import com.prasadvennam.utils.CLEAR
import com.prasadvennam.utils.CONFIRM
import com.prasadvennam.utils.DELETE_ITEM
import com.prasadvennam.utils.LIST
import com.prasadvennam.utils.LISTS
import com.prasadvennam.utils.PAGE
import com.prasadvennam.utils.SESSION_ID
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface CollectionsService {
    @GET("$ACCOUNT/{account_id}$LISTS")
    suspend fun getMyCollections(
        @Path("account_id") accountId: String,
        @Query(PAGE) page: Int,
        @Query(SESSION_ID) sessionId: String
    ): Response<ApiResponse<CollectionDto>>

    @POST(LIST)
    suspend fun addNewCollection(
        @Body collection: CreateCollectionRequestDto,
        @Query(SESSION_ID) sessionId: String
    ): Response<AddCollectionDto>

    @POST("$LIST/{list_id}/$ADD_ITEM")
    suspend fun addMediaItemToCollection(
        @Body item: AddMediaItemToCollectionRequestDto,
        @Path("list_id") collectionId: Int,
        @Query(SESSION_ID) sessionId: String
    ): Response<ApiResponse<Unit>>

    @GET("$LIST/{collection_id}")
    suspend fun getCollectionDetails(
        @Path("collection_id") collectionId: Int,
        @Query(SESSION_ID) sessionId: String,
        @Query(PAGE)page:Int,
    ): Response<ApiResponse<MovieDto>>

    @POST("$LIST/{collection_id}/$CLEAR")
    suspend fun clearCollection(
        @Path("collection_id") collectionId: Int,
        @Query(SESSION_ID) sessionId: String,
        @Query(CONFIRM) confirm: Boolean = true,
    ): Response<ApiResponse<Unit>>

    @POST("$LIST/{list_id}/$DELETE_ITEM")
    suspend fun deleteMediaItemFromCollection(
        @Body item: AddMediaItemToCollectionRequestDto,
        @Path("list_id") collectionId: Int,
        @Query(SESSION_ID) sessionId: String
    ): Response<ApiResponse<Unit>>
}
