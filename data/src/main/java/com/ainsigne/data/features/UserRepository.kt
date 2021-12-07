package com.ainsigne.data.features

import com.ainsigne.domain.features.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun refreshUsers()

    suspend fun watchUsersByLastName(lastName: String): Flow<List<User>>

    suspend fun watchAllUsers(): Flow<List<User>>
}