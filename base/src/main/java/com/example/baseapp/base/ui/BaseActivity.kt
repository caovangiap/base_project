package com.example.baseapp.base.ui

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.WindowCompat
import androidx.viewbinding.ViewBinding
import timber.log.Timber

abstract class BaseActivity<VB : ViewBinding, VM : BaseViewModel> : AppCompatActivity()  {

    private lateinit var viewBinding: VB
    abstract fun getViewBinding(): VB
    abstract fun initView()
    abstract fun listenStateView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = getViewBinding()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(viewBinding.root)
    }
    override fun onStart() {
        super.onStart()
        viewBinding = getViewBinding()
        initView()
        listenStateView()
    }

    override fun onPause() {
        super.onPause()
    }

}
