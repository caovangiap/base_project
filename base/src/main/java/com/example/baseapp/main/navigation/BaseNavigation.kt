package com.example.baseapp.main.navigation

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavController

interface BaseNavigation {
    fun openScreen(@IdRes action: Int, bundle: Bundle?= null)
    fun attach(c: NavController)
    fun backStack()
}