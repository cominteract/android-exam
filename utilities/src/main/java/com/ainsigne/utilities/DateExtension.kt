package com.ainsigne.utilities

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*


@SuppressLint("SimpleDateFormat")
val simpleFormat = SimpleDateFormat("MMM dd yyyy")

@SuppressLint("SimpleDateFormat")
val hourFormat = SimpleDateFormat("h:mm:ss aa")

@SuppressLint("SimpleDateFormat")
val fullFormat = SimpleDateFormat("MMM dd yyyy hh:mm:ss aa")

@SuppressLint("SimpleDateFormat")
val utcFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX")

@JvmInline
private value class Hours(private val minutes: Long) {
    fun dateDifferenceInHour(): Long {
        return minutes
    }
}

@JvmInline
private value class TimeLapses(private val timeLapses: Long) {

    fun timeLapsesInHour(): Long {
        return timeLapses / (MAX_MILLI * MAX_SECONDS * MAX_MINUTES)
    }

    fun timeLapsesInMinutes(): Long {
        return (timeLapses / (MAX_MILLI * MAX_SECONDS)) % MAX_MINUTES
    }
}

fun String.utcToDate () : Date? {
    utcFormat.timeZone = TimeZone.getTimeZone("UTC")
    return utcFormat.parse(this)
}

fun Date.dtDifferenceInHours(dateTimeIn: Date): Long {
    val timeLapses = TimeLapses(this.time - dateTimeIn.time)
    val hours = Hours(timeLapses.timeLapsesInHour())
    return hours.dateDifferenceInHour()
}

fun Date.dtDifferenceInMinutes(dateTimeIn: Date): Long {
    val timeLapses = TimeLapses(this.time - dateTimeIn.time)
    return timeLapses.timeLapsesInMinutes()
}

fun Date.formatToDisplay(): String {
    return simpleFormat.format(this)
}

fun Date.fullFormatToDisplay(): String {
    return fullFormat.format(this)
}

fun Date.hourFormatToDisplay(): String {
    return hourFormat.format(this)
}

fun Long.toDate(): Date {
    return Date(this * 1000)
}
