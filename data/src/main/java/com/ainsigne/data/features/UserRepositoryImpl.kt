package com.ainsigne.data.features

import com.ainsigne.domain.features.User
import com.ainsigne.local.features.UserLocalSource
import com.ainsigne.network.user.UserRemoteSource
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.serialization.ExperimentalSerializationApi
import javax.inject.Inject

@ExperimentalSerializationApi
@DelicateCoroutinesApi
class
UserRepositoryImpl
@Inject constructor(
    private val userLocalSource: UserLocalSource,
    private val userRemoteSource: UserRemoteSource
) : UserRepository {
    override suspend fun refreshUsers() {

    }

    override suspend fun watchUsersByLastName(): Flow<List<User>> {
        return flowOf()
    }

    override suspend fun watchAllUsers(): Flow<List<User>> {
        return flowOf()
    }

}