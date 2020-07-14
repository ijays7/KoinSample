package com.ijays.koinsample.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Data class that represent operation record
 */
@Entity(tableName = "logs")
data class Log(val msg: String, val timeStamp: Long) {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}