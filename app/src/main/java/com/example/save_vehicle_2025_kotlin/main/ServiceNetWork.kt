package com.example.save_vehicle_2025_kotlin.main

import android.app.Service
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.widget.Toast
import timber.log.Timber


class ServiceNetWork() : Service() {

    override fun onCreate() {
        super.onCreate()
        Timber.tag("ServiceNetWork").e("onCreate")
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }


    override fun startService(service: Intent?): ComponentName? {
        Timber.tag("ServiceNetWork").e("startService")
        return super.startService(service)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Timber.tag("ServiceNetWork").e("onStartCommand")
        Toast.makeText(this,"helooooo",Toast.LENGTH_LONG).show()
        return START_STICKY
    }

}