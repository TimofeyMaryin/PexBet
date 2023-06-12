package com.miron.logisticquizfootball.presentaion.fr

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.miron.logisticquizfootball.presentaion.Utils
import com.miron.logisticquizfootball.presentaion.view_model.QuizViewModel
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.miron.logisticquizfootball.R
import com.miron.logisticquizfootball.presentaion.navigation.Screen
import com.miron.logisticquizfootball.presentaion.ui.el.TopBar
import com.miron.logisticquizfootball.presentaion.ui.theme.Bg
import com.miron.logisticquizfootball.presentaion.view_model.FourthLevelViewModel

@Composable
fun FourthLevelScreen(
    quizViewModel: QuizViewModel,
    navController: NavController,
    fourthLevelViewModel: FourthLevelViewModel
) {
    fourthLevelViewModel.cleanGameZone()

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Bg), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.bg_texture),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        _FourthLevel(quizViewModel = quizViewModel, navController = navController, viewModel = fourthLevelViewModel)
    }

}

@Composable
private fun GameZone(
    viewModel: FourthLevelViewModel,
    modifier: Modifier,
) {
    var reload by remember { mutableStateOf(0) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ContainerImage(
                isActive = viewModel.cardId[0][0]?.isSelected?.value ?: true,
                onClick = { viewModel.selectedCard(Pair(0,0)); reload++},
                content = { ImageLevel(src = R.drawable.mask_soccer) },
            )
            ContainerImage(
                isActive = viewModel.cardId[0][1]?.isSelected?.value ?: true,
                onClick = { viewModel.selectedCard(Pair(0,1)); reload++ },
                content = { ImageLevel(src = R.drawable.mask_soccer) },
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ContainerImage(
                isActive = viewModel.cardId[1][0]?.isSelected?.value ?: true,
                onClick = { viewModel.selectedCard(Pair(1,0)); reload++ },
                content = { ImageLevel(src = R.drawable.mask_soccer) },
            )
            ContainerImage(
                isActive = viewModel.cardId[1][1]?.isSelected?.value ?: true,
                onClick = { viewModel.selectedCard(Pair(1,1)); reload++ },
                content = { ImageLevel(src = R.drawable.mask_soccer) },
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ContainerImage(
                isActive = viewModel.cardId[2][0]?.isSelected?.value ?: true,
                onClick = { viewModel.selectedCard(Pair(2,0)); reload++ },
                content = { ImageLevel(src = R.drawable.mask_soccer) },
            )
            ContainerImage(
                isActive = viewModel.cardId[2][1]?.isSelected?.value ?: true,
                onClick = { viewModel.selectedCard(Pair(2,1)); reload++ },
                content = { ImageLevel(src = R.drawable.mask_soccer) },
            )
        }
    }


    LaunchedEffect(key1 = reload, block = { })
}


@Composable
private fun ImageLevel(
    @DrawableRes src: Int,
) {
    Image(
        painter = painterResource(id = src),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
private fun ContainerImage(
    isActive: Boolean,
    onClick: () -> Unit,
    content: @Composable () -> Unit,
) {
    Box(
        modifier = Modifier
            .size(150.dp)
            .clickable {
                onClick()
            }
            .padding(Utils.padding)
            .clip(RoundedCornerShape(Utils.round))
            .border(
                width = if (isActive) Utils.border else 0.dp,
                color = if (isActive) Color.Green else Color.Transparent,
                shape = RoundedCornerShape(Utils.round)
            ),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}


@Composable
private fun _FourthLevel(
    navController: NavController,
    quizViewModel: QuizViewModel,
    viewModel: FourthLevelViewModel
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
            text = "Level 4"
        )

        GameZone(
            viewModel = viewModel,
            modifier = Modifier.constrainAs(content_ref) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
                start.linkTo(parent.start)
                bottom.linkTo(parent.bottom)
            }
        )


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
                    .clickable { navController.navigate(Screen.Home.route) { popUpTo(Screen.FourthLevel.route) { inclusive = true} } },
                contentScale = ContentScale.FillHeight,
            )
        }
    }
}