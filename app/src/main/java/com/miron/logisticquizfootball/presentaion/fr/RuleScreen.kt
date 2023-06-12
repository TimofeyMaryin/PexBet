package com.miron.logisticquizfootball.presentaion.fr

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.miron.logisticquizfootball.R
import com.miron.logisticquizfootball.presentaion.ui.theme.Bg
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miron.logisticquizfootball.presentaion.Utils
import com.miron.logisticquizfootball.presentaion.ui.theme.rubic

@Composable
fun RuleScreen(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Bg),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg_texture),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        _RuleScreen(navController = navController)
    }
}


@Composable
private  fun _RuleScreen(navController: NavController) {
    val textFontSize = 20.sp
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (close_btn_ref, content_ref) = createRefs()

        LazyColumn(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .fillMaxWidth(.9f)
                .fillMaxHeight(.8f)
                .padding(horizontal = 10.dp)
                .background(Color(0xFF0257D2))
                .constrainAs(content_ref) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
            },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item { Text(text = "Rules", fontFamily = rubic, fontSize = Utils.largeFontSize, color = Color.White) }
            item { Text(text = stringResource(id = R.string.first_rule), fontFamily = rubic, fontSize = textFontSize, color = Color.White) }
            item { Text(text = stringResource(id = R.string.second_rule), fontFamily = rubic, fontSize = textFontSize, color = Color.White) }
            item { Text(text = stringResource(id = R.string.third_rule), fontFamily = rubic, fontSize = textFontSize, color = Color.White) }
            item { Text(text = stringResource(id = R.string.fourth_rule), fontFamily = rubic, fontSize = textFontSize, color = Color.White) }
            item { Text(text = stringResource(id = R.string.fifth_rule), fontFamily = rubic, fontSize = textFontSize, color = Color.White) }
            item { Spacer(modifier = Modifier.height(20.dp)) }
        }

        Image(
            painter = painterResource(id = R.drawable.close_button),
            contentDescription = null,
            modifier = Modifier
                .size(62.dp)
                .constrainAs(close_btn_ref) {
                    top.linkTo(content_ref.top, margin = (-10).dp)
                    end.linkTo(content_ref.end, margin = (-10).dp)
                }
                .clickable { navController.popBackStack() }
        )
    }
}