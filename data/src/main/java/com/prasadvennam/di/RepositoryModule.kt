package com.prasadvennam.di

import com.prasadvennam.domain.repository.ActorRepository
import com.prasadvennam.domain.repository.CategoryTipsRepository
import com.prasadvennam.domain.repository.CollectionsRepository
import com.prasadvennam.domain.repository.GenreRepository
import com.prasadvennam.domain.repository.HistoryTipsRepository
import com.prasadvennam.domain.repository.auth.LoginRepository
import com.prasadvennam.domain.repository.MovieRepository
import com.prasadvennam.domain.repository.OnboardingRepository
import com.prasadvennam.domain.repository.RatingTipsRepository
import com.prasadvennam.domain.repository.auth.UserRepository
import com.prasadvennam.domain.repository.auth.ProfileRepository
import com.prasadvennam.domain.repository.RecentlyViewedRepository
import com.prasadvennam.domain.repository.SearchRepository
import com.prasadvennam.domain.repository.SeriesRepository
import com.prasadvennam.domain.repository.SessionRepository
import com.prasadvennam.domain.service.blur.BlurProvider
import com.prasadvennam.domain.service.theme.ThemeProvider
import com.prasadvennam.preference.BlurProviderImpl
import com.prasadvennam.preference.ThemeProviderImpl
import com.prasadvennam.repository.ActorRepositoryImpl
import com.prasadvennam.repository.CollectionsRepositoryImpl
import com.prasadvennam.repository.GenreRepositoryImpl
import com.prasadvennam.repository.MovieRepositoryImpl
import com.prasadvennam.repository.ProfileRepositoryImpl
import com.prasadvennam.repository.RecentlyViewedRepositoryImpl
import com.prasadvennam.repository.SearchRepositoryImpl
import com.prasadvennam.repository.SeriesRepositoryImpl
import com.prasadvennam.repository.login.LoginRepositoryImpl
import com.prasadvennam.repository.preference.CategoryTipsRepositoryImpl
import com.prasadvennam.repository.preference.HistoryTipsRepositoryImpl
import com.prasadvennam.repository.preference.OnboardingRepositoryImpl
import com.prasadvennam.repository.preference.RatingTipsRepositoryImpl
import com.prasadvennam.repository.preference.SessionRepositoryImpl
import com.prasadvennam.repository.preference.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMovieRepository(impl: MovieRepositoryImpl): MovieRepository

    @Binds
    @Singleton
    abstract fun bindSearchRepository(impl: SearchRepositoryImpl): SearchRepository

    @Binds
    @Singleton
    abstract fun bindSeriesRepository(impl: SeriesRepositoryImpl): SeriesRepository

    @Binds
    @Singleton
    abstract fun bindGenreRepository(impl: GenreRepositoryImpl): GenreRepository

    @Binds
    @Singleton
    abstract fun bindActorRepository(impl: ActorRepositoryImpl): ActorRepository

    @Binds
    @Singleton
    abstract fun bindCollectionsRepository(impl: CollectionsRepositoryImpl): CollectionsRepository

    @Binds
    @Singleton
    abstract fun bindLoginRepository(impl: LoginRepositoryImpl): LoginRepository

    @Binds
    @Singleton
    abstract fun bindUserRepository(impl: UserRepositoryImpl): UserRepository


    @Binds
    @Singleton
    abstract fun bindThemeProvider(impl: ThemeProviderImpl): ThemeProvider

    @Binds
    @Singleton
    abstract fun bindBlurProvider(impl: BlurProviderImpl): BlurProvider

    @Binds
    @Singleton
    abstract fun bindProfileRepository(impl: ProfileRepositoryImpl): ProfileRepository


    @Binds
    @Singleton
    abstract fun bindCategoryTipsRepository(impl: CategoryTipsRepositoryImpl): CategoryTipsRepository

 @Binds
    @Singleton
    abstract fun bindRatingTipsRepository(impl: RatingTipsRepositoryImpl): RatingTipsRepository

 @Binds
    @Singleton
    abstract fun bindHistoryTipsRepository(impl: HistoryTipsRepositoryImpl): HistoryTipsRepository


    @Binds
    @Singleton
    abstract fun bindOnboardingRepository(impl: OnboardingRepositoryImpl): OnboardingRepository


    @Binds
    @Singleton
    abstract fun bindSessionRepository(impl: SessionRepositoryImpl): SessionRepository


    @Binds
    @Singleton
    abstract fun bindRecentlyViewedRepository(impl: RecentlyViewedRepositoryImpl): RecentlyViewedRepository
}