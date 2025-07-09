package com.example.save_vehicle_2025_kotlin.core.di

import com.example.save_vehicle_2025_kotlin.core.data.remote.UserApiService
import com.example.save_vehicle_2025_kotlin.core.network.RetrofitFactory
import com.example.save_vehicle_2025_kotlin.core.network.interceptor.NetworkInterceptor
import com.example.save_vehicle_2025_kotlin.base.utils.ConstantValue
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 *  nơi cung cap dependencies (OkHttpClient, Retrofit, ApiService) thông qua @Provides hoặc @Binds.
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(
        networkInterceptor: NetworkInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(networkInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }


    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return RetrofitFactory.createRetrofit(ConstantValue.BASE_URL, okHttpClient)
    }

    @Provides @Singleton
    fun provideUserApiService(retrofit: Retrofit): UserApiService =
        retrofit.create(UserApiService::class.java)
}