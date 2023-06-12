package com.miron.logisticquizfootball.presentaion.ui.el

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.miron.logisticquizfootball.R
import com.miron.logisticquizfootball.presentaion.Utils
import com.miron.logisticquizfootball.presentaion.ui.theme.rubic

@Composable
fun TopBar(
    modifier: Modifier,
    text: String? = null,
    onClickSettings: () -> Unit,
    onClickClose: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Utils.padding)
            .then(modifier),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = { onClickSettings() }) {
            Image(
                painter = painterResource(id = R.drawable.settings_button),
                contentDescription = null,
                modifier = Modifier.size(Utils.sizeIconTopBar)
            )
        }
        
        if (text != null) {
            Text(
                text = text,
                fontFamily = rubic,
                fontSize = Utils.largeFontSize,
                color = Color.White
            )
        }
        
        IconButton(onClick = { onClickClose() }) {
            Image(
                painter = painterResource(id = R.drawable.exit_button),
                contentDescription = null,
                modifier = Modifier.size(Utils.sizeIconTopBar)
            )
        }
    }
}