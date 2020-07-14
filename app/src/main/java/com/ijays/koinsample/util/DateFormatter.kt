package com.ijays.koinsample.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * String formatter for the log dates
 */
class DateFormatter {
    private val formatter = SimpleDateFormat("d MMM yyyy HH:mm:ss")

    fun formatDate(timeStamp: Long): String {
        return formatter.format(Date(timeStamp))
    }
}