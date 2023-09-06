package com.example.masearch

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication : Application() {

    init {
        INSTANCE = this
    }

    companion object {
        lateinit var INSTANCE: BaseApplication
    }

}