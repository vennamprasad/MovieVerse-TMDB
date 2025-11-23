package com.prasadvennam.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.prasadvennam.data_source.remote.AccountRemoteDataSource
import com.prasadvennam.data_source.remote.ActorRemoteDataSource
import com.prasadvennam.data_source.remote.CollectionRemoteDataSource
import com.prasadvennam.data_source.remote.GenreRemoteDataSource
import com.prasadvennam.data_source.remote.AuthenticationRemoteDataSource
import com.prasadvennam.data_source.remote.MovieRemoteDataSource
import com.prasadvennam.data_source.remote.SearchRemoteDataSource
import com.prasadvennam.data_source.remote.SeriesRemoteDataSource
import com.prasadvennam.domain.service.language.LanguageProvider
import com.prasadvennam.data_source.remote.ProfileRemoteDataSource
import com.prasadvennam.remote.data_source.AccountRemoteDataSourceImpl
import com.prasadvennam.remote.data_source.ActorRemoteDataSourceImpl
import com.prasadvennam.remote.data_source.CollectionRemoteDataSourceImpl
import com.prasadvennam.remote.data_source.GenreRemoteDataSourceImpl
import com.prasadvennam.remote.data_source.AuthenticationRemoteDataSourceImpl
import com.prasadvennam.remote.data_source.MovieRemoteDataSourceImpl
import com.prasadvennam.remote.data_source.ProfileRemoteDataSourceImpl
import com.prasadvennam.remote.data_source.SearchRemoteDataSourceImpl
import com.prasadvennam.remote.data_source.SeriesRemoteDataSourceImpl
import com.prasadvennam.remote.interceptors.MovieVerseInterceptor
import com.prasadvennam.remote.services.ActorService
import com.prasadvennam.remote.services.CollectionsService
import com.prasadvennam.remote.services.GenreService
import com.prasadvennam.remote.services.AuthenticationService
import com.prasadvennam.remote.services.MovieService
import com.prasadvennam.remote.services.ProfileService
import com.prasadvennam.remote.services.SearchService
import com.prasadvennam.remote.services.SeriesService
import com.prasadvennam.utils.BASE_URL
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    @Singleton
    abstract fun bindSearchRemoteDataSource(impl: SearchRemoteDataSourceImpl): SearchRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindAccountRemoteDataSource(impl: AccountRemoteDataSourceImpl): AccountRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindActorRemoteDataSource(impl: ActorRemoteDataSourceImpl): ActorRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindMovieRemoteDataSource(impl: MovieRemoteDataSourceImpl): MovieRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindCollectionRemoteDataSource(impl: CollectionRemoteDataSourceImpl): CollectionRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindSeriesRemoteDataSource(impl: SeriesRemoteDataSourceImpl): SeriesRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindGenreRemoteDataSource(impl: GenreRemoteDataSourceImpl): GenreRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindLoginRemoteDataSource(impl: AuthenticationRemoteDataSourceImpl): AuthenticationRemoteDataSource


    @Binds
    @Singleton
    abstract fun bindProfileRemoteDataSource(impl: ProfileRemoteDataSourceImpl): ProfileRemoteDataSource

    companion object {

        private const val TIMEOUT = 20L
        private val contentType = "application/json".toMediaType()

        @Provides
        @Singleton
        fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
            return HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        }

        @Provides
        @Singleton
        fun provideMovieVerseInterceptor(languageProvider: LanguageProvider): MovieVerseInterceptor {
            return MovieVerseInterceptor(languageProvider)
        }

        @Provides
        @Singleton
        fun provideOkHttpClient(
            loggingInterceptor: HttpLoggingInterceptor,
            movieVerseInterceptor: MovieVerseInterceptor
        ): OkHttpClient {
            return OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .addInterceptor(movieVerseInterceptor)
                .build()
        }

        @Provides
        @Singleton
        fun provideJson(): Json {
            return Json { ignoreUnknownKeys = true }
        }

        @Provides
        @Singleton
        fun provideRetrofit(json: Json, okHttpClient: OkHttpClient): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(json.asConverterFactory(contentType))
                .client(okHttpClient)
                .build()
        }

        @Provides
        @Singleton
        fun provideActorService(retrofit: Retrofit): ActorService {
            return retrofit.create(ActorService::class.java)
        }

        @Provides
        @Singleton
        fun provideGenreService(retrofit: Retrofit): GenreService {
            return retrofit.create(GenreService::class.java)
        }

        @Provides
        @Singleton
        fun provideCollectionsService(retrofit: Retrofit): CollectionsService {
            return retrofit.create(CollectionsService::class.java)
        }

        @Provides
        @Singleton
        fun provideMovieService(retrofit: Retrofit): MovieService {
            return retrofit.create(MovieService::class.java)
        }

        @Provides
        @Singleton
        fun provideSeriesService(retrofit: Retrofit): SeriesService {
            return retrofit.create(SeriesService::class.java)
        }

        @Provides
        @Singleton
        fun provideSearchService(retrofit: Retrofit): SearchService {
            return retrofit.create(SearchService::class.java)
        }

        @Provides
        @Singleton
        fun provideLoginService(retrofit: Retrofit): AuthenticationService {
            return retrofit.create(AuthenticationService::class.java)
        }

        @Provides
        @Singleton
        fun provideProfileService(retrofit: Retrofit): ProfileService {
            return retrofit.create(ProfileService::class.java)
        }
    }
}

