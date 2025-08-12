package com.example.save_vehicle_2025_kotlin.test

import android.os.Bundle
import android.view.View
import com.airbnb.lottie.LottieDrawable
import com.example.save_vehicle_2025_kotlin.R
import com.example.save_vehicle_2025_kotlin.base.ui.BaseFragment
import com.example.save_vehicle_2025_kotlin.databinding.FragmentFirstBinding
import com.example.save_vehicle_2025_kotlin.main.MainViewModel
import com.example.save_vehicle_2025_kotlin.main.navigation.NavigationForMain
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class FirstFragment : BaseFragment<FragmentFirstBinding, MainViewModel>() {

    private lateinit var viewBinding : FragmentFirstBinding
    @Inject
    lateinit var navigation: NavigationForMain

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = FragmentFirstBinding.inflate(layoutInflater)

    }

    override fun getViewBinding(): FragmentFirstBinding {
       return viewBinding
    }

    override fun initView() {
        viewBinding.icLoading.apply {
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
        viewBinding.icLoading.setOnClickListener {
            navigation.moveFirstToSecond()
        }
    }

    override fun listenStateView() {

    }
}