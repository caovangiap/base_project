package com.example.baseapp.core.di

import android.content.Context
import com.example.baseapp.core.data.JwtBaseToken
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object JwtTokenModule {

    @Provides
    @Singleton
    fun valueJwtToken(@ApplicationContext context: Context) : JwtBaseToken{
        return JwtBaseToken(context)
    }
}