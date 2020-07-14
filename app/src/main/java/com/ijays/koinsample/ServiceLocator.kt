package com.ijays.koinsample

import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.room.Room
import com.ijays.koinsample.data.AppDatabase
import com.ijays.koinsample.data.LoggerLocalDataSource
import com.ijays.koinsample.navigator.AppNavigator
import com.ijays.koinsample.navigator.AppNavigatorImpl
import com.ijays.koinsample.util.DateFormatter

/**
 * Created by ijays on 2020/7/13.
 */
class ServiceLocator(applicationContext: Context) {

    private val logsDatabase = Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java,
        "logging.db"
    ).build()

    val loggerLocalDataSource = LoggerLocalDataSource(logsDatabase.logDao())

    fun provideDateFormatter() = DateFormatter()

    fun provideNavigator(activity: FragmentActivity): AppNavigator {
        return AppNavigatorImpl(activity)
    }
}