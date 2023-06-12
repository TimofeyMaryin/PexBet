package com.miron.logisticquizfootball.presentaion.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.miron.logisticquizfootball.R
import com.miron.logisticquizfootball.domain.model.FirstLevelQuizModel
import com.miron.logisticquizfootball.domain.model.SecondLevelQuizModel
import com.miron.logisticquizfootball.domain.quiz.LevelInfo

class QuizViewModel : ViewModel() {


    private var firstLevelItem_1_1 = mutableStateOf(false)
    private var firstLevelItem_1_2 = mutableStateOf(false)
    private var firstLevelItem_1_3 = mutableStateOf(false)

    private var firstLevelItem_2_1 = mutableStateOf(false)
    private var firstLevelItem_2_2 = mutableStateOf(false)
    private var firstLevelItem_2_3 = mutableStateOf(false)

    private var firstLevelItem_3_1 = mutableStateOf(false)
    private var firstLevelItem_3_2 = mutableStateOf(false)
    private var firstLevelItem_3_3 = mutableStateOf(false)

    private var firstLevelItem_4_1 = mutableStateOf(false)
    private var firstLevelItem_4_2 = mutableStateOf(false)
    private var firstLevelItem_4_3 = mutableStateOf(false)

    private var firstLevelItem_5_1 = mutableStateOf(false)
    private var firstLevelItem_5_2 = mutableStateOf(false)
    private var firstLevelItem_5_3 = mutableStateOf(false)

    var firstLevelModelList = listOf(
        listOf(
            FirstLevelQuizModel(R.drawable.first_level_answer_1_1, firstLevelItem_1_1,) { firstLevelItem_1_1.value = true; firstLevelItem_1_2.value = false; firstLevelItem_1_3.value = false; },
            FirstLevelQuizModel(R.drawable.first_level_answer_1_2, firstLevelItem_1_2,) { firstLevelItem_1_1.value = false; firstLevelItem_1_2.value = true; firstLevelItem_1_3.value = false; },
            FirstLevelQuizModel(R.drawable.first_level_answer_1_3, firstLevelItem_1_3,) { firstLevelItem_1_1.value = false; firstLevelItem_1_2.value = false; firstLevelItem_1_3.value = true; },
        ),
        listOf(
            FirstLevelQuizModel(R.drawable.first_level_answer_2_1, firstLevelItem_2_1,) { firstLevelItem_2_1.value = true; firstLevelItem_2_2.value = false; firstLevelItem_2_3.value = false; },
            FirstLevelQuizModel(R.drawable.first_level_answer_2_2, firstLevelItem_2_2,) { firstLevelItem_2_1.value = false; firstLevelItem_2_2.value = true; firstLevelItem_2_3.value = false; },
            FirstLevelQuizModel(R.drawable.first_level_answer_2_3, firstLevelItem_2_3,) { firstLevelItem_2_1.value = false; firstLevelItem_2_2.value = false; firstLevelItem_2_3.value = true; },
        ),
        listOf(
            FirstLevelQuizModel(R.drawable.first_level_answer_3_1, firstLevelItem_3_1,) { firstLevelItem_3_1.value = true; firstLevelItem_3_2.value = false; firstLevelItem_3_3.value = false; },
            FirstLevelQuizModel(R.drawable.first_level_answer_3_2, firstLevelItem_3_2,) { firstLevelItem_3_1.value = false; firstLevelItem_3_2.value = true; firstLevelItem_3_3.value = false;  },
            FirstLevelQuizModel(R.drawable.first_level_answer_3_3, firstLevelItem_3_3,) { firstLevelItem_3_1.value = false; firstLevelItem_3_2.value = false; firstLevelItem_3_3.value = true;  },
        ),
        listOf(
            FirstLevelQuizModel(R.drawable.first_level_answer_4_1, firstLevelItem_4_1,) { firstLevelItem_4_1.value = true; firstLevelItem_4_2.value = false; firstLevelItem_4_3.value = false; },
            FirstLevelQuizModel(R.drawable.first_level_answer_4_2, firstLevelItem_4_2,) { firstLevelItem_4_1.value = false; firstLevelItem_4_2.value = true; firstLevelItem_4_3.value = false; },
            FirstLevelQuizModel(R.drawable.first_level_answer_4_3, firstLevelItem_4_3,) { firstLevelItem_4_1.value = false; firstLevelItem_4_2.value = false; firstLevelItem_4_3.value = true; },
        ),
        listOf(
            FirstLevelQuizModel(R.drawable.first_level_answer_5_1, firstLevelItem_5_1,) { firstLevelItem_5_1.value = true; firstLevelItem_5_2.value = false; firstLevelItem_5_3.value = false;  },
            FirstLevelQuizModel(R.drawable.first_level_answer_5_2, firstLevelItem_5_2,) { firstLevelItem_5_1.value = false; firstLevelItem_5_2.value = true; firstLevelItem_5_3.value = false;  },
            FirstLevelQuizModel(R.drawable.first_level_answer_5_3, firstLevelItem_5_3,) { firstLevelItem_5_1.value = false; firstLevelItem_5_2.value = false; firstLevelItem_5_3.value = true;  },
        ),

    )

    var secondLevelText1 = mutableStateOf("")
    var secondLevelText2 = mutableStateOf("")
    var secondLevelText3 = mutableStateOf("")
    var secondLevelText4 = mutableStateOf("")
    var secondLevelText5 = mutableStateOf("")
    val secondLevelModelList = listOf(
        SecondLevelQuizModel("Level 1", "Vencedor da Copa do Mundo de 2022?", R.drawable.second_level_1, secondLevelText1) { secondLevelText1.value = it },
        SecondLevelQuizModel("Level 2", "Vencedor da Liga dos Campeões de 2020?", R.drawable.second_level_2, secondLevelText2) { secondLevelText2.value = it },
        SecondLevelQuizModel("Level 3", "Quem possui 6 bolas de ouro?", R.drawable.second_level_3, secondLevelText3) { secondLevelText3.value = it },
        SecondLevelQuizModel("Level 4", "Quantos seguidores Ronaldo tem no Instagram?", R.drawable.second_level_4, secondLevelText4) { secondLevelText4.value = it },
        SecondLevelQuizModel("Level 5", "Quantos seguidores Mbappe tem no Instagram?", R.drawable.second_level_5, secondLevelText5) { secondLevelText5.value = it }
    )


    var firstLevelCorrectItem by mutableStateOf(false)
    var firstLevelIncorrectItem1 by mutableStateOf(false)
    var firstLevelIncorrectItem2 by mutableStateOf(false)

    var thirdLevelCorrectItem by mutableStateOf(false)
    var thirdLevelIncorrectItem1 by mutableStateOf(false)
    var thirdLevelIncorrectItem2 by mutableStateOf(false)

    var secondLevelUserAnswers by mutableStateOf("")


    fun selectInThirdLevel(index: Int) {
        clearAllSelectionInFirstLevel(2)
        when (index) {
            0 -> thirdLevelCorrectItem = true
            1 -> thirdLevelIncorrectItem1 = true
            2 -> thirdLevelIncorrectItem2 = true
        }
    }


    private fun clearAllSelectionInFirstLevel(value: Int) {
        if (value == 1) {
            firstLevelCorrectItem = false
            firstLevelIncorrectItem1 = false
            firstLevelIncorrectItem2 = false
            return
        }
        if (value == 2) {
            thirdLevelCorrectItem = false
            thirdLevelIncorrectItem1 = false
            thirdLevelIncorrectItem2 = false
        }

    }

    fun changeValueSecondLevel(value: String) {
        secondLevelUserAnswers = value
    }



}