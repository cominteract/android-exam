package com.ainsigne.local.module

import com.ainsigne.local.features.UserLocalSource
import com.ainsigne.local.roomdao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class LocalSourceModule {


    @Provides
    fun provideUserLocalSource(userDao: UserDao) =
        UserLocalSource(userDao = userDao)

}
