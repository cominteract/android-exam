package com.ainsigne.network.base

import java.sql.Time

data class LocationResponse(
    val city: String,
    val country: String,
    val state: String,
    val postcode: Int,
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
