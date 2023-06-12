package com.miron.logisticquizfootball.presentaion.fr

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.miron.logisticquizfootball.R
import com.miron.logisticquizfootball.presentaion.navigation.Screen
import com.miron.logisticquizfootball.presentaion.ui.theme.Bg
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    var isCanShowAnim by remember { mutableStateOf(false) }
    val animContent by animateFloatAsState(targetValue = if (isCanShowAnim) 1f else 0f, tween(4_000))
    Box(modifier = Modifier.fillMaxSize().background(Bg), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.bg_texture),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Image(
            painter = painterResource(id = R.drawable.splash_screen_content),
            contentDescription = null,
            modifier = Modifier.height(80.dp).alpha(animContent),
            contentScale = ContentScale.FillHeight
        )
    }

    LaunchedEffect(
        key1 = true,
        block = {
            isCanShowAnim = true
            delay(4_000)
            navController.navigate(Screen.Home.route){
                popUpTo(Screen.SplashScreen.route) {
                    inclusive = true
                }
            }
        },
    )
}