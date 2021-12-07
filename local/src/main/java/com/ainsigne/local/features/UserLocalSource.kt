package com.ainsigne.local.features

import com.ainsigne.local.roomdao.UserDao
import kotlinx.coroutines.flow.Flow
import java.util.*
import javax.inject.Inject

class UserLocalSource @Inject constructor(
    private val userDao: UserDao
) {
    fun watchUsersByLastname(lastName: String): Flow<List<User>> {
        return userDao.watchUsersByLastName(lastName = lastName)
    }

    fun watchAllUsers(): Flow<List<User>> {
        return userDao.watchAllUsers()
    }

    suspend fun insertUsers(users: List<User>) {
        userDao.insertUsers(users = users)
    }

    suspend fun deleteAllUsers() {
        userDao.deleteAllUsers()
    }



}
