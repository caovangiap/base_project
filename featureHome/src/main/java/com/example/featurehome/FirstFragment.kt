package com.example.featurehome

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.airbnb.lottie.LottieDrawable
import com.example.baseapp.base.ui.BaseFragment
import com.example.featurehome.databinding.FragmentFirstBinding
import com.example.featurehome.databinding.SplashFragmentBinding
import com.example.featurehome.ui.HomeViewModel
import com.prodigy.feature.girlfriend.navigation.NavigationGirlFriend
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import timber.log.Timber
import kotlin.getValue

@AndroidEntryPoint
class FirstFragment : BaseFragment<SplashFragmentBinding, HomeViewModel>() {

    private lateinit var viewBinding : SplashFragmentBinding
    @Inject
    lateinit var navigation: NavigationGirlFriend
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = SplashFragmentBinding.inflate(layoutInflater)

    }

    override fun getViewBinding(): SplashFragmentBinding {
       return viewBinding
    }

    override fun initView() {
    }

    override fun listenStateView() {

    }

    override fun viewModelForBase(): HomeViewModel {
        return viewModel
    }

    override fun setOnClick() {

    }
}