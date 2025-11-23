package com.prasadvennam.domain.usecase.movie

import com.prasadvennam.domain.model.CreditsInfo
import com.prasadvennam.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieCreditsUseCase @Inject constructor(
    private val detailsRepository: MovieRepository
) {
    suspend operator fun invoke(id: Int): CreditsInfo =
       detailsRepository.getCreditsMovie(id = id)
}