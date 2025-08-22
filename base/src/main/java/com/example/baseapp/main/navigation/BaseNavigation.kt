package com.example.baseapp.main.navigation

import android.os.Bundle
import androidx.annotation.IdRes

interface BaseNavigation {
    fun openScreen(@IdRes action: Int, bundle: Bundle?= null)
}