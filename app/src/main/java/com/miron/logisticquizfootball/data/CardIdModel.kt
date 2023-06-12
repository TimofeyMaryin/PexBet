package com.miron.logisticquizfootball.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class CardIdModel(
    var isSelected: MutableState<Boolean> = mutableStateOf(false),
    var isPair: Boolean = false
)
