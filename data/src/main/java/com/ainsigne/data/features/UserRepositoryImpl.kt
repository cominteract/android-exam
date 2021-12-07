package com.ainsigne.data.features

import android.util.Log
import com.ainsigne.domain.features.User
import com.ainsigne.local.features.UserLocalSource
import com.ainsigne.local.features.mapper.mapDomainToLocal
import com.ainsigne.local.features.mapper.mapLocalToDomain
import com.ainsigne.network.user.UserRemoteSource
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
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
        val remoteUsers = userRemoteSource.refreshUsers()
        val localUsers = remoteUsers.map {
            it.mapDomainToLocal()
        }
        userLocalSource.insertUsers(localUsers)
    }

    override suspend fun watchUsersByLastName(lastName: String): Flow<List<User>> {
        return userLocalSource.watchUsersByLastname(lastName = lastName).flatMapLatest {
            flowOf(it.map { user ->
                user.mapLocalToDomain()
            })
        }
    }

    override suspend fun watchAllUsers(): Flow<List<User>> {
        return userLocalSource.watchAllUsers().flatMapLatest {
            flowOf(it.map { user ->
                user.mapLocalToDomain()
            })
        }
    }

}