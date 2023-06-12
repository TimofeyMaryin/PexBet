package com.miron.logisticquizfootball.domain.model

import androidx.compose.runtime.MutableState

data class SecondLevelQuizModel(
    val lvlText: String,
    val questionTitle: String,
    val img: Int,
    val valueTextField: MutableState<String>,
    val textChange: (String) -> Unit,
)
