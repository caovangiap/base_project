package com.prodigy.feature.girlfriend.navigation

import android.os.Bundle

interface NavigationGirlFriend {
    fun moveSplashToWelcome()
    fun moveSplashToHome()
    fun moveWelcomeToOnboarding()
    fun moveWelcomeToHome()

    fun moveOnboardingToHome()
    fun moveDiscoverToSearchChild()
    fun moveToBoxChat(bundle: Bundle?)

    fun moveToCreateCharacter(bundle: Bundle?)

    fun moveToSetting()
    fun moveSettingToHome(bundle: Bundle)

    fun moveToBoxChatFromChildSearch(bundle: Bundle?)

    fun moveToReportFromBoxChat()
}