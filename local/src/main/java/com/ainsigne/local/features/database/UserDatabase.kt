package com.ainsigne.local.features.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ainsigne.local.USER_DB
import com.ainsigne.local.features.User
import com.ainsigne.local.roomdao.UserDao

@Database(
    entities = [
        User::class
    ],
    version = 1,
    exportSchema = false
)

abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {

        fun getInstance(context: Context): UserDatabase = buildDatabase(context)

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context,
                UserDatabase::class.java,
                USER_DB
            )
                .fallbackToDestructiveMigration()
                .build()
    }
}
