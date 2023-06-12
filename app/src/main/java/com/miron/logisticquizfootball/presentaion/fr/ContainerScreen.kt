package com.miron.logisticquizfootball.presentaion.fr

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.miron.logisticquizfootball.R
import com.miron.logisticquizfootball.presentaion.Utils
import com.miron.logisticquizfootball.presentaion.navigation.Screen
import kotlin.system.exitProcess

@Composable
fun ContainerScreen(
    navController: NavController,
    content: @Composable () -> Unit,
) {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (exit_ic, setting_ic, content_ref) = createRefs()

        IconButton(
            onClick = { navController.navigate(Screen.SettingsScreen.route) },
            modifier = Modifier.constrainAs(setting_ic) {
                top.linkTo(parent.top, margin = Utils.padding)
                start.linkTo(parent.start, margin = Utils.padding)
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.settin_ic),
                contentDescription = stringResource(id = R.string.settings_description),
            )
        }

        IconButton(
            onClick = { exitProcess(0) },
            modifier = Modifier.constrainAs(exit_ic) {
                top.linkTo(parent.top, margin = Utils.padding)
                end.linkTo(parent.end, margin = Utils.padding)
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.close_ic),
                contentDescription = stringResource(id = R.string.exit_description),
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .constrainAs(content_ref) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                },
            contentAlignment = Alignment.Center
        )  {
            content()
        }

    }
}