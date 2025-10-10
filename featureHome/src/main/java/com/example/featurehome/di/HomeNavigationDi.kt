package com.prodigy.feature.girlfriend.di

import com.example.baseapp.core.di.ChildNavigator
import com.example.baseapp.core.di.HomeNavigation
import com.example.baseapp.main.navigation.BaseNavigation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import com.prodigy.feature.girlfriend.navigation.home_navigation.HomeNavigationGirlFriend
import com.prodigy.feature.girlfriend.navigation.home_navigation.HomeNavigationGirlFriendImp
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object HomeNavigationDi {

    @ActivityScoped
    @HomeNavigation
    @Provides
    fun provideNavigator(navigation : ChildNavigator): BaseNavigation {
        return navigation
    }

    @ActivityScoped
    @Provides
    fun provideNavigationHomeGirl(navigationHomeIml: HomeNavigationGirlFriendImp): HomeNavigationGirlFriend {
        return navigationHomeIml
    }
}