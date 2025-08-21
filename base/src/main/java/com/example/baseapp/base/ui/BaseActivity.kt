package com.example.baseapp.base.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding


abstract class BaseActivity<VB : ViewBinding, VM : BaseViewModel> : AppCompatActivity() {

    private lateinit var viewBinding : VB
    abstract fun getViewBinding(): VB
    abstract fun initView()
    abstract fun listenStateView()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = getViewBinding()
        setContentView(viewBinding.root)

    }

    override fun onStart() {
        super.onStart()
        initView()
        listenStateView()
    }

    override fun onPause() {
        super.onPause()
    }

}
