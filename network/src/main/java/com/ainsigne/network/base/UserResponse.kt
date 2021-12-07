package com.ainsigne.network.base

data class UserResponse(
    val gender: String,
    val name: NameResponse,
    val phone: String,
    val cell: String,
    val email: String,
    val dob: DOBResponse,
    val picture: PictureResponse,
    val location: LocationResponse
)

data class ResultResponse(
    val results: List<UserResponse>,
    val info: InfoResponse
)


data class InfoResponse(
    val seed: String,
    val results: Int,
    val page: Int,
    val version: String
)