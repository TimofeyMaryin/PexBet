package com.miron.logisticquizfootball.presentaion.ui.el

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.miron.logisticquizfootball.presentaion.ui.theme.rubic

@Composable
fun CustomSlider(
    value: Float,
    onValueChange: (Float) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(.9f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Slider(
            value = value,
            onValueChange = { onValueChange(it) },
            steps = 1,
            valueRange = 0f..2f,
            modifier = Modifier.fillMaxWidth(),
            colors = SliderDefaults.colors(
                inactiveTrackColor = Color.White,
                inactiveTickColor = Color.White,

                activeTrackColor = Color(0xFFC4F800),
                activeTickColor = Color(0xFFC4F800),
                thumbColor = Color(0xFFC4F800)
            )
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "track1", fontSize = 18.sp, color = Color.White, fontFamily = rubic, )
            Text(text = "track2", fontSize = 18.sp, color = Color.White, fontFamily = rubic, )
            Text(text = "track3", fontSize = 18.sp, color = Color.White, fontFamily = rubic, )
        }
    }
}


@Preview(widthDp = 420)
@Composable
fun PreviewCustomSlider() {
    var value by remember { mutableStateOf(1f) }
    CustomSlider(value = value, onValueChange = { value = it })
}