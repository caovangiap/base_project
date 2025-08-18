package com.example.save_vehicle_2025_kotlin.main

import android.view.View
import com.airbnb.lottie.LottieDrawable
import com.example.save_vehicle_2025_kotlin.R
import com.example.save_vehicle_2025_kotlin.base.ui.BaseActivity
import com.example.save_vehicle_2025_kotlin.databinding.SecondActivityBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class SecondActivity : BaseActivity<SecondActivityBinding, MainViewModel>() {


    private lateinit var binding : SecondActivityBinding
    override fun getViewBinding(): SecondActivityBinding {
        binding = SecondActivityBinding.inflate(layoutInflater)
        return binding
    }

    override fun initView() {
        binding.icLoading.apply {
            setAnimation(R.raw.ic_loading)
            repeatCount = LottieDrawable.INFINITE
            visibility = View.VISIBLE

            // đợi view đo xong
            post {
                addLottieOnCompositionLoadedListener {
                    playAnimation()
                    Timber.e("Started animation at resume")
                }
            }
        }
    }

    override fun listenStateView() {

    }

}