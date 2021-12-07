package com.ainsigne.local.features.mapper

import com.ainsigne.domain.features.User

fun User.mapDomainToLocal(
): com.ainsigne.local.features.User {
    return com.ainsigne.local.features.User(
        id = "${this.fullName}_${dob}",
        gender = this.gender,
        state = this.state,
        streetName = this.streetName,
        age = this.age,
        email = this.email,
        cell = this.cell,
        first = this.first,
        last = this.last,
        thumbnailUrl = this.thumbnailUrl,
        title = this.title,
        timezoneDescription = this.timezoneDescription,
        fullName = this.fullName,
        largeUrl = this.largeUrl,
        mediumUrl = this.mediumUrl,
        phone = this.phone,
        dob = this.dob,
        city = this.city,
        country = this.country
    )
}

fun com.ainsigne.local.features.User.mapLocalToDomain(
): User {
    return User(
        id = "${this.fullName}_${dob}",
        gender = this.gender,
        state = this.state,
        streetName = this.streetName,
        age = this.age,
        email = this.email,
        cell = this.cell,
        first = this.first,
        last = this.last,
        thumbnailUrl = this.thumbnailUrl,
        title = this.title,
        timezoneDescription = this.timezoneDescription,
        fullName = this.fullName,
        largeUrl = this.largeUrl,
        mediumUrl = this.mediumUrl,
        phone = this.phone,
        dob = this.dob,
        city = this.city,
        country = this.country,
        fullAddress = "${this.streetName} ${this.city} ${this.state} ${this.country}"
    )
}