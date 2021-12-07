package com.ainsigne.network.module

import com.ainsigne.network.user.UserRemoteSource
import com.ainsigne.network.user.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteSourceModule {

    @ExperimentalSerializationApi
    @Provides
    @Singleton
    fun providePersonRemoteSource(userService: UserService) =
        UserRemoteSource(userService)

}
