package com.example.tsukurepo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// Applicationクラスを継承
@HiltAndroidApp
class TsukurepoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}