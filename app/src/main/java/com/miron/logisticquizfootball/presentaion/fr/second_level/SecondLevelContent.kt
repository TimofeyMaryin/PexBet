package com.miron.logisticquizfootball.presentaion.fr.second_level

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.miron.logisticquizfootball.R
import com.miron.logisticquizfootball.domain.model.SecondLevelQuizModel
import com.miron.logisticquizfootball.presentaion.navigation.Screen
import com.miron.logisticquizfootball.presentaion.ui.el.TopBar
import com.miron.logisticquizfootball.presentaion.ui.theme.rubic

@Composable
fun SecondLevelContent(
    navController: NavController,
    model: SecondLevelQuizModel,
    onClickNext: () -> Unit,
) {
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
            text = model.lvlText
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
                text = model.questionTitle,
                fontFamily = rubic,
                fontSize = 36.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(40.dp))

            Image(
                painter = painterResource(id = model.img),
                contentDescription = null,
                modifier = Modifier.height(180.dp)
            )
            Spacer(modifier = Modifier.height(40.dp))

            OutlinedTextField(
                value = model.valueTextField.value,
                onValueChange = { model.textChange(it) },
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .border(1.dp, Color(0xFFC4F800), RoundedCornerShape(12.dp))
                    .fillMaxWidth(.7f)
                    .height(80.dp),
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.Black,
                    backgroundColor = Color.White,
                ),
                singleLine = true,
                textStyle = TextStyle(
                    fontSize = 28.sp,
                    fontFamily = rubic,
                    color = Color.Black
                )
            )
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
                    .clickable { onClickNext() },
                contentScale = ContentScale.FillHeight,
            )
        }
    }
}