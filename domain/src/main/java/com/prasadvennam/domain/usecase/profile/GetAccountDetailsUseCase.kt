package com.prasadvennam.domain.usecase.profile

import com.prasadvennam.domain.repository.auth.ProfileRepository
import javax.inject.Inject

class GetAccountDetailsUseCase @Inject constructor(
    private val profileRepository: ProfileRepository
) {
    suspend operator fun invoke(
        accountId: String, sessionId: String
    ) = profileRepository.getUserInfo(
            accountId = accountId,
            sessionId = sessionId
        )
}