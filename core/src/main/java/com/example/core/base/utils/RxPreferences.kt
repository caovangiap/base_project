package com.example.core.base.utils

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RxPreferences @Inject constructor(
    @ApplicationContext private val context: Context
){
    private val prefs: SharedPreferences by lazy {
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    // Ví dụ các key bạn cần
    private val KEY_USER_TOKEN        = prefs.getString("user_token", "")
    private val KEY_REFRESH_TOKEN     = prefs.getString("refresh_token", "")
    private val KEY_CAMERA_ACCESS     = prefs.getString("camera_access_token", "")


    fun getRefreshToken(): String{

        return "new_token"
    }

    companion object {
        private const val PREFS_NAME = "app_prefs"
    }

}