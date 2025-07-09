package com.example.save_vehicle_2025_kotlin.main

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.airbnb.lottie.LottieDrawable
import com.example.save_vehicle_2025_kotlin.R
import com.example.save_vehicle_2025_kotlin.base.ui.BaseActivity
import com.example.save_vehicle_2025_kotlin.databinding.BaseActivityBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : BaseActivity<BaseActivityBinding, MainViewModel>() {

    private lateinit var binding : BaseActivityBinding
    override fun getViewBinding(): BaseActivityBinding {
        binding = BaseActivityBinding.inflate(layoutInflater)
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

    override fun onResume() {
        super.onResume()
        binding.icLoading.playAnimation()
    }

    override fun listenStateView() {
//        showLoading()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}