package com.example.baseapp.core.data

data class BaseMutableResults <out T> (
    val code : Int,
    val data: MutableList<Nothing>,
    val message: String
){
    fun successCall() :Boolean{
        return code == 200
    }
}