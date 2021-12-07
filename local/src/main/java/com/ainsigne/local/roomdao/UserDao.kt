package com.ainsigne.local.roomdao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ainsigne.local.features.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * from persons_list WHERE last == :lastName")
    fun watchUsersByLastName(lastName: String): Flow<List<User>>

    @Query("SELECT * from persons_list")
    fun watchAllUsers(): Flow<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(users: List<User>)
}
