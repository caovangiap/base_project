package com.example.baseapp.base.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.baseapp.base.utils.SingleLiveEvent


open class BaseViewModel  : ViewModel() {

    val isLoading = SingleLiveEvent<Boolean>()


    fun loading(boolean: Boolean){
        isLoading.postValue(boolean)
    }
}