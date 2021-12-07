package com.ainsigne.personsdemoapp.ui.main

import com.ainsigne.domain.extension.EMPTY
import com.ainsigne.domain.features.User

sealed class PersonsState {
    object ShowLoader : PersonsState()
    object HideLoader : PersonsState()
    data class Error(val error: String = EMPTY) : PersonsState()
    data class SuccessPersonsDisplay(val Personss: List<User>) : PersonsState()
}