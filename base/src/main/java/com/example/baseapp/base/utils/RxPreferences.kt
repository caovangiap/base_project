package com.example.baseapp.base.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RxPreferences @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val prefs: SharedPreferences by lazy {
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun setJvmToken(token: String? = null) {
        prefs.edit { putString(JVM_TOKEN, token ?: "") }

    }

    fun getJvmToken(): String? {
        return prefs.getString(JVM_TOKEN, "")
    }

    fun setRefreshToken(flag: String) {
        prefs.edit { putString(FLAG_REFRESH_TOKEN, flag) }
    }

    fun getRefreshToken(): String? {
        return prefs.getString(FLAG_REFRESH_TOKEN, "")
    }

    fun setNextCursor(cursor: Int) {
        prefs.edit { putInt(Cursor_Pager, cursor) }
    }

    fun getNextCursor(): Int? {
        return prefs.getInt(Cursor_Pager, 0)
    }

    companion object {
        private const val PREFS_NAME = "app_prefs"
        private const val JVM_TOKEN = "JVM TOKEN"
        private const val FLAG_REFRESH_TOKEN = "FLAG_REFRESH_TOKEN"

        private const val Cursor_Pager = "Cursor_Pager"

    }

}