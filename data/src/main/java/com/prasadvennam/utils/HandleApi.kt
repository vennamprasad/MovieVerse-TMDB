package com.prasadvennam.utils

import com.prasadvennam.domain.exception.MovieVerseException.BadRequestException
import com.prasadvennam.domain.exception.MovieVerseException.ForbiddenRequestException
import com.prasadvennam.domain.exception.MovieVerseException.NoInternetException
import com.prasadvennam.domain.exception.MovieVerseException.NotFoundException
import com.prasadvennam.domain.exception.MovieVerseException.ServerErrorException
import com.prasadvennam.domain.exception.MovieVerseException.ServerNotFoundException
import com.prasadvennam.domain.exception.MovieVerseException.ServiceUnavailableException
import com.prasadvennam.domain.exception.MovieVerseException.TooManyRequestsException
import com.prasadvennam.domain.exception.MovieVerseException.TooMuchTimeException
import com.prasadvennam.domain.exception.MovieVerseException.UnauthorizedRequestException
import com.prasadvennam.domain.exception.MovieVerseException.UnknownException
import retrofit2.HttpException
import retrofit2.Response
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

suspend inline fun <T> handleApi(
    crossinline execute: suspend () -> Response<T>
): T {
    try {
        val response = execute()
        val body = response.body()
        if (response.isSuccessful && body != null) {
            return body
        } else {
            when (response.code()) {
                400 -> throw BadRequestException
                401 -> throw UnauthorizedRequestException
                403 -> throw ForbiddenRequestException
                404 -> throw NotFoundException
                429 -> throw TooManyRequestsException
                500 -> throw ServerErrorException
                503 -> throw ServiceUnavailableException
                else -> throw UnknownException
            }
        }
    } catch (_: ConnectException) {
        throw NoInternetException
    } catch (e: HttpException) {
        when (e.code()) {
            500 -> throw ServerErrorException
            404 -> throw NotFoundException
            else -> throw UnknownException
        }
    } catch (_: SocketTimeoutException) {
        throw TooMuchTimeException
    } catch (e: UnknownHostException) {
        if (e.message?.contains("Unable to resolve host") == true)
            throw NoInternetException
        else
            throw ServerNotFoundException
    } catch (_: Throwable) {
        throw UnknownException
    }
}