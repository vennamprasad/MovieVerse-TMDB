package com.prasadvennam.remote.services

import com.prasadvennam.remote.dto.profile.response.AccountDto
import com.prasadvennam.remote.dto.login.GuestSessionDto
import com.prasadvennam.remote.dto.login.LoginResponseDto
import com.prasadvennam.remote.dto.login.RequestTokenDto
import com.prasadvennam.remote.dto.login.SessionDto
import com.prasadvennam.utils.ACCOUNT
import com.prasadvennam.utils.LOGIN
import com.prasadvennam.utils.NEW_GUEST_SESSION
import com.prasadvennam.utils.NEW_SESSION
import com.prasadvennam.utils.NEW_TOKEN
import com.prasadvennam.utils.PASSWORD
import com.prasadvennam.utils.REQUEST_TOKEN
import com.prasadvennam.utils.SESSION_ID_WITH_EQUAL
import com.prasadvennam.utils.USERNAME
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthenticationService {

    @GET(NEW_TOKEN)
    suspend fun createRequestToken(): Response<RequestTokenDto>

    @POST(LOGIN)
    suspend fun validateLoginWithRequestToken(
        @Query(USERNAME) username: String,
        @Query(PASSWORD) password: String,
        @Query(REQUEST_TOKEN) requestToken: String
    ): Response<LoginResponseDto>

    @POST(NEW_SESSION)
    suspend fun createAuthenticatedUserSession(
        @Query(REQUEST_TOKEN) requestToken: String
    ): Response<SessionDto>

    @GET(NEW_GUEST_SESSION)
    suspend fun createGuestUserSession(): Response<GuestSessionDto>

    @GET(ACCOUNT)
    suspend fun getUserId(
        @Query(SESSION_ID_WITH_EQUAL) sessionId: String
    ): Response<AccountDto>

}
