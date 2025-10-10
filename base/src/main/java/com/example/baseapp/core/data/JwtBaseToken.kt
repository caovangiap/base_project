package com.example.baseapp.core.data

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.provider.Settings
import android.util.Base64
import java.security.MessageDigest

/**
 * tham so cho get jwtToken
 */
class JwtBaseToken (
    private val context: Context
) {

    @SuppressLint("HardwareIds")
    fun getDeviceId(): String {
        return Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
    }

    fun getSignature(packageName: String): String? {
        try {
            val info: PackageInfo = context.packageManager.getPackageInfo(
                packageName,
                PackageManager.GET_SIGNATURES
            )
            for (signature in info.signatures!!) {
                val md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                return Base64.encodeToString(md.digest(), Base64.NO_WRAP)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    fun getCountryCode(): String {
        val locale = context.resources.configuration.locale
        val countryCode = locale.country
        return countryCode
    }
}