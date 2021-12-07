package com.ainsigne.local.features

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ainsigne.domain.extension.EMPTY
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "persons_list")
data class User(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "gender") val gender: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "first") val first: String,
    @ColumnInfo(name = "last") val last: String,
    @ColumnInfo(name = "fullName") val fullName: String,
    @ColumnInfo(name = "city") val city: String,
    @ColumnInfo(name = "country") val country: String,
    @ColumnInfo(name = "state") val state: String,
    @ColumnInfo(name = "streetName") val streetName: String,
    @ColumnInfo(name = "timezoneDescription") val timezoneDescription: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "dob") val dob: String,
    @ColumnInfo(name = "age") val age: Int,
    @ColumnInfo(name = "phone") val phone: String,
    @ColumnInfo(name = "cell") val cell: String,
    @ColumnInfo(name = "largeUrl") val largeUrl: String,
    @ColumnInfo(name = "mediumUrl") val mediumUrl: String,
    @ColumnInfo(name = "thumbnailUrl") val thumbnailUrl: String
): Parcelable