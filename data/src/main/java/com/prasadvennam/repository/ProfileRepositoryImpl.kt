package com.prasadvennam.repository

import com.prasadvennam.data_source.remote.ProfileRemoteDataSource
import com.prasadvennam.domain.model.UserInfo
import com.prasadvennam.domain.repository.auth.ProfileRepository
import com.prasadvennam.mapper.toDomain
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val profileRemoteDataSource: ProfileRemoteDataSource
) : ProfileRepository {
    override suspend fun getUserInfo(
        accountId: String,
        sessionId: String
    ): UserInfo =
        profileRemoteDataSource.getUserInfo(accountId, sessionId).toDomain()


    override suspend fun logout(sessionId: String): Boolean =
        profileRemoteDataSource.logout(sessionId).success != false
}