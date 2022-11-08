package com.example.tripgo

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext

@HiltAndroidApp
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        appContext=applicationContext
    }

    companion object{
        lateinit var  appContext:Context

        fun getApplication(): Context {
            return appContext;
        }
    }
}