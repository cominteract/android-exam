package com.ainsigne.domain.features

import com.ainsigne.domain.extension.EMPTY

data class User(
    val id: String = EMPTY,
    val gender: String = EMPTY,
    val title: String = EMPTY,
    val first: String = EMPTY,
    val last: String = EMPTY,
    val fullName: String = EMPTY,
    val city: String = EMPTY,
    val country: String = EMPTY,
    val state: String = EMPTY,
    val streetName: String = EMPTY,
    val timezoneDescription: String = EMPTY,
    val email: String = EMPTY,
    val dob: String = EMPTY,
    val age: Int = 0,
    val phone: String = EMPTY,
    val cell: String = EMPTY,
    val largeUrl: String = EMPTY,
    val mediumUrl: String = EMPTY,
    val thumbnailUrl: String = EMPTY

)