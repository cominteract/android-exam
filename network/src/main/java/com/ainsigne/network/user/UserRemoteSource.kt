package com.ainsigne.network.user

import com.ainsigne.domain.dispatcher.dispatcherIO
import com.ainsigne.domain.exception.apiSafeCall
import com.ainsigne.network.BuildConfig
import com.ainsigne.network.user.UserService
import com.ainsigne.network.user.mapper.mapForecastToDommain
import kotlinx.coroutines.withContext
import kotlinx.serialization.ExperimentalSerializationApi
import javax.inject.Inject

@ExperimentalSerializationApi
class UserRemoteSource @Inject constructor(
    private val userService: UserService
) {
    suspend fun refreshUsers() = apiSafeCall {
        withContext(dispatcherIO) {
            val users = userService.getUserList(
                results = "150"
            )
            users.map {
                it.mapForecastToDommain()
            }
        }
    }
}
