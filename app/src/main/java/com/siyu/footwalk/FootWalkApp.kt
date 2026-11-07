package com.siyu.footwalk

import android.app.Application
import com.siyu.footwalk.di.AppContainer

class FootWalkApp : Application() {
    lateinit var container: AppContainer
        private set

    override fun onCreate() {
        super.onCreate()
        container = AppContainer(this)
    }
}