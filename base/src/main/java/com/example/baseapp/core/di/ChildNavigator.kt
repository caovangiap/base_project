package com.example.baseapp.core.di

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.example.baseapp.main.navigation.BaseNavigation
import javax.inject.Inject

class ChildNavigator @Inject constructor() : BaseNavigation {
    private var controller: NavController? = null
    override fun attach(c: NavController) { controller = c }
    fun detach() { controller = null }

    override fun openScreen(action: Int, bundle: Bundle?) {
        controller?.navigate(action, bundle)
    }

    override fun backStack() {
        controller?.popBackStack()
    }
}