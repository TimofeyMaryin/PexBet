package com.miron.logisticquizfootball.presentaion.ui.el

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LevelChooseButton(
    modifier: Modifier = Modifier,
    onAction: () -> Unit,
    text: String,
    enable: Boolean = true,
) {
    Button(
        onClick = onAction,
        modifier = Modifier.then(modifier),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.secondary
        ),
        enabled = enable
    ) {
        Text(
            text = text,
            color = MaterialTheme.colors.onSecondary,
        )
    }

}