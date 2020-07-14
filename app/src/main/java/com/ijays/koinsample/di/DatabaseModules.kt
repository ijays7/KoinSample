package com.ijays.koinsample.di

import android.content.Context
import androidx.room.Room
import com.ijays.koinsample.data.AppDatabase
import com.ijays.koinsample.data.LogDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

/**
 * Created by ijays on 2020/7/14.
 */
@InstallIn(ApplicationComponent::class)
@Module
object DatabaseModules {

    @Provides
    fun provideLogDao(database: AppDatabase): LogDao {
        return database.logDao()
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java, "logging.db"
        ).build()
    }
}