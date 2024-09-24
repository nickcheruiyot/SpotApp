package com.example.spotapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SpotApp : Application(){
    override fun onCreate() {
        super.onCreate()
        // Any application-level initialization
    }
}