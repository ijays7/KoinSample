package com.ijays.koinsample.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ijays.koinsample.model.Data
import io.reactivex.Observable

/**
 * Created by ijays on 2020/1/29.
 */
@Dao
interface DataDao {

    @Query("select * from data")
    fun queryDataFromDB(): Observable<List<Data>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(data: Data)
}