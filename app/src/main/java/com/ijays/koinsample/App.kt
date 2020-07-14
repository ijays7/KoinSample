package com.ijays.koinsample

import android.app.Application
import java.lang.NullPointerException

/**
 * Created by ijays on 2020/1/29.
 */
class App : Application() {
    companion object {
        private var sInstance: App? = null

        fun getInstance(): Application {
            return sInstance ?: throw NullPointerException("App instance must not be null")
        }
    }

    lateinit var serviceLocator: ServiceLocator

    override fun onCreate() {
        super.onCreate()
        sInstance = this
        serviceLocator = ServiceLocator(applicationContext)
    }
}