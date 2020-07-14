package com.ijays.koinsample.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 * Created by ijays on 2020/7/14.
 */
@Dao
interface LogDao {

    @Query("SELECT * FROM logs ORDER BY id DESC")
    fun getAll(): List<Log>

    @Insert
    fun insertAll(vararg logs: Log)

    @Query("DELETE FROM logs")
    fun nukeTable()
}