package com.ainsigne.network.user.mapper

import com.ainsigne.domain.features.User
import com.ainsigne.network.base.UserResponse

fun UserResponse.mapForecastToDommain(

): User {
    return User(
        gender = this.gender,
        state = this.location.state,
        streetName = this.location.street.name,
        age = this.dob.age,
        email = this.email,
        cell = this.cell,
        first = this.name.first,
        last = this.name.last,
        thumbnailUrl = this.picture.thumbnail,
        title = this.name.title,
        timezoneDescription = this.location.timezone.description,
        fullName = "${this.name.first} ${this.name.last}",
        largeUrl = this.picture.large,
        mediumUrl = this.picture.medium,
        phone = this.phone,
        dob = this.dob.date,
        city = this.location.city,
        country = this.location.country

    )
}