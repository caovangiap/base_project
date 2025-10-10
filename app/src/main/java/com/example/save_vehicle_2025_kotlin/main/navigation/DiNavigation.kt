package com.example.save_vehicle_2025_kotlin.main.navigation

import com.example.baseapp.core.di.ChildNavigator
import com.example.baseapp.core.di.GlobalNavigation
import com.example.baseapp.main.navigation.BaseNavigation
import com.prodigy.feature.girlfriend.navigation.NavigationGirlFriend
import com.prodigy.feature.girlfriend.navigation.NavigationGirlFriendIml
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object DiNavigation {

    @ActivityScoped
    @GlobalNavigation
    @Provides
    fun provideNavigator(navigation : ChildNavigator): BaseNavigation {
        return navigation
    }

    @ActivityScoped
    @Provides
    fun provideNavigationHome(navigationHomeIml: NavigationGirlFriendIml): NavigationGirlFriend {
        return navigationHomeIml
    }
}