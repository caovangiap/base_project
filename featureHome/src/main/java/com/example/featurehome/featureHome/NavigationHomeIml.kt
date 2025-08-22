package com.example.featurehome.featureHome

import com.example.baseapp.main.navigation.BaseNavigation
import javax.inject.Inject
import com.example.featurehome.R

class NavigationHomeIml @Inject constructor(
    private val navigation: BaseNavigation
) : NavigationHome {
    override fun moveFirstToSecond() {
        navigation.openScreen(R.id.action_firstFragment_to_secondFragment )
    }
}