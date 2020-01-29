package com.ijays.koinsample.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by ijays on 2020/1/29.
 */
@Entity(tableName = "data")
data class Data(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    var str: String
)