package com.ainsigne.data.module


import com.ainsigne.data.features.UserRepository
import com.ainsigne.data.features.UserRepositoryImpl
import com.ainsigne.local.features.UserLocalSource
import com.ainsigne.network.user.UserRemoteSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.serialization.ExperimentalSerializationApi

@OptIn(DelicateCoroutinesApi::class)
@ExperimentalSerializationApi
@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @DelicateCoroutinesApi
    @Provides
    @ViewModelScoped
    fun provideUserRepository(
        userLocalSource: UserLocalSource,
        userRemoteSource: UserRemoteSource
    ): UserRepository = UserRepositoryImpl(
        userLocalSource,
        userRemoteSource
    )
}
