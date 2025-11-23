package com.prasadvennam.domain.usecase.preference

import com.prasadvennam.domain.repository.auth.UserRepository
import javax.inject.Inject

class GetUserDetailsUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke() = userRepository.getUser()
}