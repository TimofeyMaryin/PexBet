package com.miron.logisticquizfootball.presentaion.fr.first_level

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.miron.logisticquizfootball.R
import com.miron.logisticquizfootball.presentaion.navigation.Screen
import com.miron.logisticquizfootball.presentaion.ui.el.TopBar
import com.miron.logisticquizfootball.presentaion.ui.theme.Bg
import com.miron.logisticquizfootball.presentaion.ui.theme.rubic
import com.miron.logisticquizfootball.presentaion.view_model.QuizViewModel

@Composable
fun FirstLevelScreenTwo(
    quizViewModel: QuizViewModel,
    navController: NavController
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Bg), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.bg_texture),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        FirstScreenContent(
            navController = navController,
            topBarText = "Level 2",
            questionText = "Qual das seguintes opções se aplica a Rooney",
            imgSrcQuestion = R.drawable.first_level_quistion_2,
            model = quizViewModel.firstLevelModelList[1]
        ) {
            navController.navigate(Screen.FirstLevelThree.route)
        }
    }

}
