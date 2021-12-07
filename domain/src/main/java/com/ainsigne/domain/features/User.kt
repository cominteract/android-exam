package com.ainsigne.domain.features

import com.ainsigne.domain.extension.EMPTY

data class User(
    val gender: String,
    val title: String,
    val first: String,
    val last: String,
    val fullName: String,
    val city: String,
    val country: String,
    val state: String,
    val streetName: String,
    val timezoneDescription: String,
    val email: String,
    val dob: String,
    val age: Int,
    val phone: String,
    val cell: String,
    val largeUrl: String,
    val mediumUrl: String,
    val thumbnailUrl: String

)