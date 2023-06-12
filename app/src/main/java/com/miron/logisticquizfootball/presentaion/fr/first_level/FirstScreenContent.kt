package com.miron.logisticquizfootball.presentaion.fr.first_level

import androidx.compose.foundation.Image
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
import com.miron.logisticquizfootball.domain.model.FirstLevelQuizModel
import com.miron.logisticquizfootball.presentaion.navigation.Screen
import com.miron.logisticquizfootball.presentaion.ui.el.TopBar
import com.miron.logisticquizfootball.presentaion.ui.theme.rubic

@Composable
fun FirstScreenContent(
    navController: NavController,
    topBarText: String,
    questionText: String,
    imgSrcQuestion: Int,
    model: List<FirstLevelQuizModel>,
    onNavigate: () -> Unit,
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
            text = topBarText
        )
        Column(
            modifier = Modifier.constrainAs(content_ref) {
                top.linkTo(topBar_ref.bottom)
                end.linkTo(parent.end)
                start.linkTo(parent.start)
                bottom.linkTo(parent.bottom)
            },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = questionText,
                fontFamily = rubic,
                fontSize = 32.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(12.dp))

            Image(
                painter = painterResource(id = imgSrcQuestion),
                contentDescription = null,
                modifier = Modifier.size(180.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(12.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth(.9f)
            ) {
                FirstLevelGameEl(modifier = Modifier, imageSrc = model[0].img, isActive = model[0].isActive.value ) { model[0].onClickModel() }
                FirstLevelGameEl(modifier = Modifier, imageSrc = model[1].img, isActive = model[1].isActive.value) { model[1].onClickModel() }
            }
            FirstLevelGameEl(modifier = Modifier, imageSrc = model[2].img, isActive = model[2].isActive.value) { model[2].onClickModel() }
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
                    .clickable { onNavigate() },
                contentScale = ContentScale.FillHeight,
            )
        }
    }

}