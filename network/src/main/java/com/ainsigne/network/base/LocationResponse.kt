package com.ainsigne.network.base

import com.ainsigne.domain.extension.EMPTY
import java.sql.Time

data class LocationResponse(
    val city: String = EMPTY,
    val country: String = EMPTY,
    val state: String = EMPTY,
    val street: StreetResponse,
    val coordinates: CoordinateResponse,
    val timezone: TimezoneResponse
)

data class StreetResponse(
    val number: Int,
    val name: String
)

data class CoordinateResponse(
    val latitude: Double,
    val longitude: Double
)

data class TimezoneResponse(
    val offset: String,
    val description: String
)
