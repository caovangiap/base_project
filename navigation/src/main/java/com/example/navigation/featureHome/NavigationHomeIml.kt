package com.example.navigation.featureHome

import com.example.navigation.BaseNavigation
import javax.inject.Inject
import com.example.navigation.R

class NavigationHomeIml @Inject constructor(
    private val navigation: BaseNavigation
) : NavigationHome {
    override fun moveFirstToSecond() {
        navigation.openScreen(R.id.action_firstFragment_to_secondFragment )
    }
}