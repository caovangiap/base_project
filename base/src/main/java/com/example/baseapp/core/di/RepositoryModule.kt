package com.example.baseapp.core.di

import com.example.baseapp.core.data.repository.UserRepository
import com.example.baseapp.core.data.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindUserRepo(impl: UserRepositoryImpl): UserRepository

}