package com.ainsigne.network.user

import com.ainsigne.domain.extension.EMPTY
import com.ainsigne.network.base.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {

    @GET(".")
    suspend fun getUserList(
        @Query("results") results: String = EMPTY
    ): List<UserResponse>
}
