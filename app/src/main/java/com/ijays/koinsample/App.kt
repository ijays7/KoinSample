package com.ijays.koinsample

import android.app.Application
import com.ijays.koinsample.di.applicationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
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

    override fun onCreate() {
        super.onCreate()
        sInstance = this

        startKoin {
            // use Koin Andorid Logger
            androidLogger()
            // declare Android context
            androidContext(this@App)
            // declare modules to use
            modules(listOf(applicationModule))
        }

    }
}