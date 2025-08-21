package com.example.featurehome

import android.os.Bundle
import android.view.View
import com.airbnb.lottie.LottieDrawable
import com.example.baseapp.MainViewModel
import com.example.baseapp.base.ui.BaseFragment
import com.example.navigation.databinding.FragmentFirstBinding
import com.example.navigation.featureHome.NavigationHome
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import com.example.navigation.R
import timber.log.Timber

@AndroidEntryPoint
class FirstFragment : BaseFragment<FragmentFirstBinding, MainViewModel>() {

    private lateinit var viewBinding : FragmentFirstBinding
    @Inject
    lateinit var navigation: NavigationHome

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