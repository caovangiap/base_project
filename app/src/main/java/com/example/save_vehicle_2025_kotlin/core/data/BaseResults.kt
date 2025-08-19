package com.example.save_vehicle_2025_kotlin.core.data

import androidx.lifecycle.MutableLiveData

data class BaseResults<out T> (
    val code : Int,
    val data: BaseResults<Nothing>?
){
    fun successCall() :Boolean{
        return code == 200
    }
}