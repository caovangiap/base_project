package com.example.core.core.data

import androidx.lifecycle.MutableLiveData

data class BaseResults<out T> (
    val code : Int,
    val data: T
){
    fun successCall() :Boolean{
        return code == 200
    }
}