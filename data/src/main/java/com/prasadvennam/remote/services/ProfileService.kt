package com.prasadvennam.remote.services

import com.prasadvennam.remote.dto.profile.response.AccountDto
import com.prasadvennam.remote.dto.profile.response.LogoutResponseDto
import com.prasadvennam.utils.ACCOUNT
import com.prasadvennam.utils.AUTHENTICATION
import com.prasadvennam.utils.SESSION_ID
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProfileService {

    @GET("$ACCOUNT/{account_id}")
    suspend fun getUserInfo(
        @Path("account_id") accountId:String,
        @Query(SESSION_ID) sessionId:String,
    ): Response<AccountDto>

    @DELETE("${AUTHENTICATION}session")
    suspend fun logout(
        @Query("session_id") sessionId: String
    ): Response<LogoutResponseDto>
}