package com.miron.logisticquizfootball.presentaion.fr

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.miron.logisticquizfootball.R
import com.miron.logisticquizfootball.presentaion.Utils
import com.miron.logisticquizfootball.presentaion.modifiers.styleHomeButton
import com.miron.logisticquizfootball.presentaion.navigation.Screen
import com.miron.logisticquizfootball.presentaion.ui.el.LevelChooseButton
import com.miron.logisticquizfootball.presentaion.ui.el.TopBar
import com.miron.logisticquizfootball.presentaion.ui.theme.Bg
import kotlin.system.exitProcess

@Composable
fun HomeScreen(navController: NavController) {
    ContainerScreen(navController = navController) {
        _HomeScreen(navController = navController)
    }
}

@Composable
private fun __HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        LevelChooseButton(
            onAction = { navController.navigate(Screen.FirstLevelOne.route) },
            text = stringResource(
                id = R.string.first_level,
            ),
        )
        LevelChooseButton(
            onAction = { navController.navigate(Screen.SecondLevelOne.route) },
            text = stringResource(
                id = R.string.second_level,
            ),
        )
        LevelChooseButton(
            onAction = { navController.navigate(Screen.ThirdLevel.route) },
            text = stringResource(
                id = R.string.third_level,
            ),
        )
        LevelChooseButton(
            onAction = { navController.navigate(Screen.FourthLevel.route) },
            text = stringResource(
                id = R.string.fourth_level,
            ),
        )
        LevelChooseButton(
            onAction = { navController.navigate(Screen.InfoScreen.route) },
            text = stringResource(
                id = R.string.info_screen_title,
            ),
        )
    }
}

@Composable
private fun _HomeScreen(navController: NavController) {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (bg_ref, topBar_ref, menu_ref) = createRefs()
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Bg)
                .constrainAs(bg_ref) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
            contentAlignment = Alignment.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.bg_texture),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        TopBar(
            modifier = Modifier.padding(top = 40.dp).constrainAs(topBar_ref) {
                top.linkTo(parent.top, margin = 20.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            onClickSettings = { navController.navigate(Screen.SettingsScreen.route) },
            onClickClose = { exitProcess(0) }
        )

        Column(
            modifier = Modifier.fillMaxWidth().constrainAs(menu_ref) {
                top.linkTo(topBar_ref.bottom)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.title_application),
                contentDescription = null,
                modifier = Modifier.height(150.dp).padding(bottom = Utils.marginUntilTitle),
                contentScale = ContentScale.Crop
            )
            Image(
                painter = painterResource(id = R.drawable.first_level),
                contentDescription = null,
                modifier = Modifier.styleHomeButton { navController.navigate(Screen.FirstLevelOne.route) },
                contentScale = ContentScale.Crop
            )
            Image(
                painter = painterResource(id = R.drawable.second_level),
                contentDescription = null,
                modifier = Modifier.styleHomeButton { navController.navigate(Screen.SecondLevelOne.route) },
                contentScale = ContentScale.Crop
            )
            Image(
                painter = painterResource(id = R.drawable.third_level),
                contentDescription = null,
                modifier = Modifier.styleHomeButton { navController.navigate(Screen.ThirdLevel.route) },
                contentScale = ContentScale.Crop
            )
            Image(
                painter = painterResource(id = R.drawable.fouth_level),
                contentDescription = null,
                modifier = Modifier.styleHomeButton { navController.navigate(Screen.FourthLevel.route)},
                contentScale = ContentScale.Crop
            )
            Image(
                painter = painterResource(id = R.drawable.rule_button),
                contentDescription = null,
                modifier = Modifier.styleHomeButton { navController.navigate(Screen.RuleScreen.route) },
                contentScale = ContentScale.Crop
            )
        }

    }
}