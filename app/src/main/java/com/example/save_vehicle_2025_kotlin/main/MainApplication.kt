package com.example.save_vehicle_2025_kotlin.main

import android.app.Application
import com.example.save_vehicle_2025_kotlin.BuildConfig

import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber


@HiltAndroidApp
class MainApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        Timber.tag("MainApplication").e("onCreate")
    }
}