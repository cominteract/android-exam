package com.ainsigne.local.module

import android.content.Context
import com.ainsigne.local.features.database.UserDatabase
import com.ainsigne.local.roomdao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DaoModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext ctx: Context) =
        UserDatabase.getInstance(ctx)

    @Provides
    fun getUserDao(db: UserDatabase): UserDao {
        return db.userDao()
    }

}
