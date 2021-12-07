package com.ainsigne.network.user

import com.ainsigne.domain.dispatcher.dispatcherIO
import com.ainsigne.domain.exception.apiSafeCall
import com.ainsigne.network.BuildConfig
import com.ainsigne.network.user.UserService
import com.ainsigne.network.user.mapper.mapUserResponseToDomain
import kotlinx.coroutines.withContext
import kotlinx.serialization.ExperimentalSerializationApi
import javax.inject.Inject

@ExperimentalSerializationApi
class UserRemoteSource @Inject constructor(
    private val userService: UserService
) {
    suspend fun refreshUsers() = apiSafeCall {
        withContext(dispatcherIO) {
            val results = userService.getUserList(
                results = "150"
            ).results
            results.map {
                it.mapUserResponseToDomain()
            }
        }
    }
}
