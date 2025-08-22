package com.example.save_vehicle_2025_kotlin.main.navigation

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.baseapp.main.navigation.BaseNavigation
import com.example.featurehome.featureHome.NavigationHome
import com.example.featurehome.featureHome.NavigationHomeIml
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import com.example.save_vehicle_2025_kotlin.R

@Module
@InstallIn(ActivityComponent::class)
object DiNavigation {

    @ActivityScoped
    @Provides
    fun provideNavigator(activity: FragmentActivity): BaseNavigation {
        val navHostFragment = activity.supportFragmentManager
            .findFragmentById(R.id.nav_host) as NavHostFragment
        val navController = navHostFragment.navController

        return object : BaseNavigation {
            override fun openScreen(action: Int, bundle: Bundle?) {
                navController.navigate(action,bundle)
            }
        }
    }

    @ActivityScoped
    @Provides
    fun provideNavigationHome(navigationHomeIml: NavigationHomeIml): NavigationHome {
        return navigationHomeIml
    }
}