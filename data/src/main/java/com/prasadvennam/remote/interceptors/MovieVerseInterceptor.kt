package com.prasadvennam.remote.interceptors

import com.prasadvennam.domain.service.language.LanguageProvider
import com.prasadvennam.tmdb.data.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class MovieVerseInterceptor(
    private val languageProvider: LanguageProvider
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url

        val language = languageProvider.currentLanguage.value

        val newUrl = originalUrl.newBuilder()
            .addQueryParameter("language", language)
            .build()

        val newRequest = originalRequest.newBuilder()
            .url(newUrl)
            .header("Authorization", "Bearer ${BuildConfig.BEARER_TOKEN}")
            .build()

        return chain.proceed(newRequest)
    }
}