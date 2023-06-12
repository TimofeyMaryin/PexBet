package com.miron.logisticquizfootball.presentaion.fr

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
import com.miron.logisticquizfootball.presentaion.ui.el.CustomCheckBox
import com.miron.logisticquizfootball.presentaion.ui.el.TopBar
import com.miron.logisticquizfootball.presentaion.ui.theme.Bg
import com.miron.logisticquizfootball.presentaion.ui.theme.rubic
import com.miron.logisticquizfootball.presentaion.view_model.QuizViewModel

@Composable
fun ThirdLevelScreen(
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
        _ThirdLevel(quizViewModel = quizViewModel, navController = navController)
    }
}

@Composable
private fun _ThirdLevel(navController: NavController, quizViewModel: QuizViewModel) {

    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (topBar_ref, content_ref, btnNext_ref) = createRefs()
        TopBar(
            modifier = Modifier.constrainAs(topBar_ref) {
                top.linkTo(parent.top, margin = 20.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            onClickSettings = { navController.navigate(Screen.SettingsScreen.route) },
            onClickClose = { navController.navigate(Screen.Home.route) { popUpTo(Screen.SecondLevelOne.route) { inclusive = true } } },
            text = "Level 3"
        )
        Column(
            modifier = Modifier.constrainAs(content_ref) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
                start.linkTo(parent.start)
                bottom.linkTo(parent.bottom)
            },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {


            Text(
                text = "What ia your name?",
                fontFamily = rubic,
                fontSize = 36.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(20.dp))

            Image(
                painter = painterResource(id = R.drawable.level_1_correct),
                contentDescription = null,
                modifier = Modifier.size(180.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            CheckBoxThirdLevel(text = "lemon", isActive = quizViewModel.thirdLevelIncorrectItem1) {
                quizViewModel.selectInThirdLevel(1)
            }
            CheckBoxThirdLevel(text = "strawberry", isActive = quizViewModel.thirdLevelCorrectItem) {
                quizViewModel.selectInThirdLevel(0)
            }
            CheckBoxThirdLevel(text = "watermelon", isActive = quizViewModel.thirdLevelIncorrectItem2) {
                quizViewModel.selectInThirdLevel(2)
            }

        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(btnNext_ref) {
                    bottom.linkTo(parent.bottom, margin = 20.dp)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                },
            contentAlignment = Alignment.CenterEnd,
        ) {
            Image(
                painter = painterResource(id = R.drawable.next_button),
                contentDescription = null,
                modifier = Modifier
                    .height(50.dp)
                    .clickable { navController.navigate(Screen.FourthLevel.route) },
                contentScale = ContentScale.FillHeight,
            )
        }
    }
}

@Composable
private fun CheckBoxThirdLevel(
    text: String,
    isActive: Boolean,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(.64f)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        CustomCheckBox(isActive = isActive, modifier = Modifier.weight(1f))
        Box(
            contentAlignment = Alignment.CenterStart,
            modifier = Modifier
                .padding(start = 10.dp)
                .weight(3f)
        ) {
            Text(
                text = text,
                color = Color.Black,
                fontFamily = rubic,
                fontSize = 28.sp
            )
        }
    }
}
