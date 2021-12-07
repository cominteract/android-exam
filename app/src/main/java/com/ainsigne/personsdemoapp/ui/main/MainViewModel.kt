package com.ainsigne.personsdemoapp.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import com.ainsigne.data.features.UserRepository
import com.ainsigne.personsdemoapp.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userRepository: UserRepository
) : BaseViewModel() {

    private val mutablePersonsState: MutableSharedFlow<PersonsState> = MutableSharedFlow()

    val personsState: SharedFlow<PersonsState> = mutablePersonsState

    private val refreshContent = MutableLiveData(true)

    init {
        viewModelScope.launch {
            userRepository.refreshUsers()
        }
        viewModelScope.launch(
            CoroutineExceptionHandler { _, error ->
                emitState {
                    mutablePersonsState.emit(PersonsState.HideLoader)
                    mutablePersonsState.emit(PersonsState.Error(error.localizedMessage))
                }
            }
        ) {
            combine(
                refreshContent.asFlow(),
                userRepository.watchAllUsers()
            ) { _, data->
                data
            }.flatMapLatest { data ->
                flowOf(data)
            }.collect { data ->
                mutablePersonsState.emit(PersonsState.HideLoader)
                mutablePersonsState.emit(PersonsState.SuccessPersonsDisplay(data))
            }
        }

    }

    fun refreshContent() {
        refreshContent.postValue(true)
    }
}