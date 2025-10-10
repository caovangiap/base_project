package com.example.baseapp.core.di

import android.content.Context
import com.example.baseapp.BuildConfig
import com.example.baseapp.base.utils.RxPreferences
import com.example.baseapp.core.events.TokenRefreshEvent
import com.example.baseapp.core.network.RetrofitFactory
import com.example.baseapp.core.network.interceptor.NetworkInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
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
    fun provideGson(): Gson {
        return GsonBuilder()
            .setLenient()
            .create()
    }

    @Provides
    @Singleton
    fun provideNetworkInterceptor(
        @ApplicationContext context: Context,
        rxPreferences: RxPreferences,
        tokenRefreshEvent: TokenRefreshEvent
    ): Interceptor {
        return NetworkInterceptor(context, rxPreferences, tokenRefreshEvent )
    }


    @Provides
    @Singleton
    fun provideOkHttpClient(
        requestInterceptor: Interceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(305, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return RetrofitFactory.createRetrofit(BuildConfig.BASE_URL, okHttpClient)
    }

}