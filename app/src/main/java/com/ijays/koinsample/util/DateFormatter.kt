package com.ijays.koinsample.util

import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

/**
 * String formatter for the log dates
 *
 * To tell Hilt how to provide instances of a type, add the @Inject annotation to the constructor of
 * the class you want to be injected.
 */
class DateFormatter @Inject constructor() {
    private val formatter = SimpleDateFormat("d MMM yyyy HH:mm:ss")

    fun formatDate(timeStamp: Long): String {
        return formatter.format(Date(timeStamp))
    }
}