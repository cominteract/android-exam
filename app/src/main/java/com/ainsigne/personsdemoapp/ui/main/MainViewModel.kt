package com.ainsigne.personsdemoapp.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asFlow
import com.ainsigne.data.features.UserRepository
import com.ainsigne.personsdemoapp.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userRepository: UserRepository
) : BaseViewModel() {

    private val mutablePersonsState: MutableSharedFlow<PersonsState> = MutableSharedFlow()

    val personsState: SharedFlow<PersonsState> = mutablePersonsState

    private val refreshContent = MutableLiveData(true)

    init {


    }

    fun refreshContent() {
        refreshContent.postValue(true)
    }
}