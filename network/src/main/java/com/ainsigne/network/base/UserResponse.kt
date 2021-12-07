package com.ainsigne.network.base

class UserResponse(
    val gender: String,
    val name: NameResponse,
    val location: LocationResponse,
    val email: String,
    val dob: DOBResponse,
    val phone: String,
    val cell: String,
    val picture: PictureResponse
)
