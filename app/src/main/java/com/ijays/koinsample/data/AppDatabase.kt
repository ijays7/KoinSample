package com.ijays.koinsample.data

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Created by ijays on 2020/1/29.
 */
@Database(entities = [Log::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun logDao(): LogDao
}