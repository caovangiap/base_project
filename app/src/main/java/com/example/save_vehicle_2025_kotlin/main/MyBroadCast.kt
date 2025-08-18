package com.example.save_vehicle_2025_kotlin.main

import android.annotation.SuppressLint
import android.app.ActivityManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import timber.log.Timber


class MyBroadCast: BroadcastReceiver(){



    override fun onReceive(context: Context?, intent: Intent?) {
        if (context == null || intent == null) return
        if (Intent.ACTION_TIMEZONE_CHANGED == intent.action) {
            val timeZone = intent.getStringExtra("time-zone") ?: "Unknown"
            Timber.tag("MyBroadCast").d("Broadcast received: ${intent.action}, Time zone: $timeZone")
            Log.d("MyBroadCast", "Time zone changed: $timeZone")

            // Kiểm tra trạng thái ứng dụng
            val isForeground = context.isAppInForeground()
            Timber.tag("MyBroadCast").d("App in foreground: $isForeground")

            val serviceIntent = Intent(context, ServiceNetWork::class.java)
            try {
                context.startService(serviceIntent)
                Timber.tag("MyBroadCast").d("startService called")
            } catch (e: Exception) {
                Timber.tag("MyBroadCast").e("Error: ${e.message}")
            }
        }
    }


    private fun Context.isAppInForeground(): Boolean {
        val am = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val processes = am.runningAppProcesses ?: return false
        val packageName = packageName
        return processes.any { process ->
            process.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND
                    && process.processName == packageName
        }
    }

}