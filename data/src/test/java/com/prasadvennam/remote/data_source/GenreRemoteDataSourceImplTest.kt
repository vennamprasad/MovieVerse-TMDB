package com.prasadvennam.remote.data_source

import com.google.common.truth.Truth.assertThat
import com.prasadvennam.data_source.remote.GenreRemoteDataSource
import com.prasadvennam.domain.exception.MovieVerseException
import com.prasadvennam.remote.dto.genre.GenreDto
import com.prasadvennam.remote.dto.genre.GenreResponse
import com.prasadvennam.remote.services.GenreService
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import retrofit2.HttpException
import retrofit2.Response

class GenreRemoteDataSourceImplTest {

    private lateinit var genreService: GenreService
    private lateinit var genreRemoteDataSource: GenreRemoteDataSource

    @BeforeEach
    fun setup() {
        genreService = mockk()
        genreRemoteDataSource = GenreRemoteDataSourceImpl(genreService)
    }

    @Test
    fun `when getMoviesGenres succeeds then return the list of genres for movies `() = runTest {
        val expected = GenreResponse(listOf(GenreDto(1, "Action")))
        coEvery { genreService.getMoviesGenres() } returns Response.success(expected)

        val result = genreRemoteDataSource.getMoviesGenres()

        assertThat(expected).isEqualTo(result)
    }

    @Test
    fun `when call getSeriesGenres succeeds then return the list of genres for series`() = runTest {
        val expected = GenreResponse(listOf(GenreDto(2, "Drama")))
        coEvery { genreService.getSeriesGenres() } returns Response.success(expected)

        val result = genreRemoteDataSource.getSeriesGenres()

        assertThat(expected).isEqualTo(result)
    }

    @Test
    fun `should throw CineVerseException when call getSeriesGenres fails`() = runTest {

        coEvery { genreService.getSeriesGenres() } throws HttpException(
            Response.error<Any>(
            500,
            "Server Error".toResponseBody("application/json".toMediaType())
        ))
        assertThrows<MovieVerseException> {
            genreRemoteDataSource.getSeriesGenres()
        }
    }


}