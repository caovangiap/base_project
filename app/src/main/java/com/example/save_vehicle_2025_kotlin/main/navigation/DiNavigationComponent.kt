package com.example.save_vehicle_2025_kotlin.main.navigation

import com.example.save_vehicle_2025_kotlin.main.MainActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DiNavigationComponent {


    @Singleton
    @Provides
    fun provideNavigation(): NavigationForMain {
        return NavigationForMainIml()
    }

}