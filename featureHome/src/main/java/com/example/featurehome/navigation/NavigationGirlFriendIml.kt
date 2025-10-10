package com.prodigy.feature.girlfriend.navigation

import android.os.Bundle
import com.example.baseapp.core.di.GlobalNavigation
import com.example.baseapp.main.navigation.BaseNavigation
import javax.inject.Inject


class NavigationGirlFriendIml @Inject constructor(
    @GlobalNavigation
    private val navigation: BaseNavigation
) : NavigationGirlFriend {

    override fun moveSplashToWelcome() {

    }

    override fun moveSplashToHome() {

    }

    override fun moveWelcomeToOnboarding() {

    }

    override fun moveWelcomeToHome() {

    }

    override fun moveOnboardingToHome() {

    }

    override fun moveDiscoverToSearchChild() {

    }

    override fun moveToBoxChat(bundle: Bundle?) {

    }

    override fun moveToCreateCharacter(bundle: Bundle?) {

    }

    override fun moveToSetting() {

    }

    override fun moveSettingToHome(bundle: Bundle) {

    }

    override fun moveToBoxChatFromChildSearch(bundle: Bundle?) {

    }

    override fun moveToReportFromBoxChat() {

    }

}