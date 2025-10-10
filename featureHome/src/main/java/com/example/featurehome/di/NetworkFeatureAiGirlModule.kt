package com.prodigy.feature.girlfriend.di
import com.prodigy.feature.girlfriend.remote.GirlFriendApiService
import com.prodigy.feature.girlfriend.repository.UserRepository
import com.prodigy.feature.girlfriend.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkFeatureAiGirlModule {

    @Provides
    @Singleton
    fun provideUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ): UserRepository {
        return userRepositoryImpl
    }

    @Provides
    @Singleton
    fun provideUserApiService (retrofit: Retrofit): GirlFriendApiService {
        return retrofit.create(GirlFriendApiService::class.java)
    }

}