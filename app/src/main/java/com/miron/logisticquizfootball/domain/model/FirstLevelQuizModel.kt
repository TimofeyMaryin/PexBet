package com.miron.logisticquizfootball.domain.model

import androidx.compose.runtime.MutableState

data class FirstLevelQuizModel(
    val img: Int,
    val isActive: MutableState<Boolean>,
    val onClickModel: () -> Unit,
)
