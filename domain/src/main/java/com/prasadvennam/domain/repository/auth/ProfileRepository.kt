package com.prasadvennam.domain.repository.auth

import com.prasadvennam.domain.model.UserInfo

interface ProfileRepository {
    suspend fun getUserInfo(accountId:String, sessionId:String): UserInfo
    suspend fun logout(sessionId: String): Boolean
}