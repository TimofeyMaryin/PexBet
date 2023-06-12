package com.miron.logisticquizfootball.domain.quiz

import androidx.annotation.DrawableRes

data class LevelInfo(
    @DrawableRes val questionImg: List<Int>,
    val questionText: String? = null,
    val answerVariable: List<Any>?
)
