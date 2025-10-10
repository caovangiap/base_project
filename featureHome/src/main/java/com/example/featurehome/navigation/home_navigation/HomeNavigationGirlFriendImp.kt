package com.prodigy.feature.girlfriend.navigation.home_navigation

import com.example.baseapp.core.di.HomeNavigation
import com.example.baseapp.main.navigation.BaseNavigation
import com.example.featurehome.R
import javax.inject.Inject

class HomeNavigationGirlFriendImp @Inject constructor (
    @HomeNavigation
    private val navigationGirlFriend: BaseNavigation
) : HomeNavigationGirlFriend {

    override fun moveToForYouFragment() {
        navigationGirlFriend.openScreen(R.id.forYouFragment)
    }
}