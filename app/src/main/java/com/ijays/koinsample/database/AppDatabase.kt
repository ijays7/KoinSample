package com.ijays.koinsample.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ijays.koinsample.App
import com.ijays.koinsample.model.Data

/**
 * Created by ijays on 2020/1/29.
 */
@Database(entities = [Data::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        private var sInstance: AppDatabase? = null

        fun getInstance(): AppDatabase {
            if (sInstance == null) {
                sInstance = Room.databaseBuilder(
                    App.getInstance(),
                    AppDatabase::class.java,
                    "app_database.db"
                ).build()
            }
            return sInstance ?: throw NullPointerException("AppDatabase instance must not be null")
        }


    }

    abstract fun dataDao(): DataDao


}