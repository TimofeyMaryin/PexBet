package com.miron.logisticquizfootball.presentaion.fr

import android.content.Context
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.miron.logisticquizfootball.R
import com.miron.logisticquizfootball.presentaion.Utils
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.miron.logisticquizfootball.presentaion.ui.el.CustomSlider
import com.miron.logisticquizfootball.presentaion.ui.el.SettingsVolumeIndicator
import com.miron.logisticquizfootball.presentaion.ui.theme.Bg
import com.miron.logisticquizfootball.presentaion.ui.theme.BgContainer
import com.miron.logisticquizfootball.presentaion.ui.theme.rubic
import com.miron.logisticquizfootball.presentaion.view_model.SettingsViewModel

@Composable
fun SettingsScreen(
    navController: NavController,
    settingsViewModel: SettingsViewModel
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

        _SettingsScreen(navController = navController, settingsViewModel = settingsViewModel)
    }
}

@Composable
private fun _SettingsScreen(navController: NavController, settingsViewModel: SettingsViewModel) {
    ConstraintLayout() {
        val (close_button_ref, content_ref) = createRefs()

        ContentSettings(
            navController = navController,
            modifier = Modifier.constrainAs(content_ref) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
            },
            settingsViewModel = settingsViewModel,
        )

        Image(
            painter = painterResource(id = R.drawable.close_button),
            contentDescription = null,
            modifier = Modifier
                .size(Utils.sizeIconTopBar)
                .constrainAs(close_button_ref) {
                    top.linkTo(content_ref.top, margin = (-10).dp)
                    end.linkTo(content_ref.end, margin = (-10).dp)
                }
                .clickable { navController.popBackStack() }
        )
    }
}

@Composable
private fun ContentSettings(
    navController: NavController,
    modifier: Modifier,
    settingsViewModel: SettingsViewModel,
) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(BgContainer)
            .fillMaxWidth(.9f)
            .fillMaxSize(.7f)
            .then(modifier),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Settings", fontSize = Utils.largeFontSize, color = Color.White, fontFamily = rubic)
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "volume", fontSize = 18.sp, fontFamily = rubic, color = Color.White, )
        SettingsVolumeIndicator(settingsViewModifier = settingsViewModel, modifier = Modifier)
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "music", fontSize = 18.sp, fontFamily = rubic, color = Color.White, )
        CustomSlider(
            value = settingsViewModel.currentMusicIndex,
            onValueChange = {
                settingsViewModel.currentMusicIndex = it
                settingsViewModel.startMediaPlayer(context = context)
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
    }


}


