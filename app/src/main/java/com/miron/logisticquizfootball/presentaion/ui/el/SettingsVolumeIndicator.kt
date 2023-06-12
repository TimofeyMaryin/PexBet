package com.miron.logisticquizfootball.presentaion.ui.el

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.miron.logisticquizfootball.presentaion.view_model.SettingsViewModel
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun SettingsVolumeIndicator(
    settingsViewModifier: SettingsViewModel,
    modifier: Modifier,
) {

    val radius = 150f
    val smallRadius = 30f
    Canvas(
        modifier = Modifier
            .size(260.dp)
            .clickable { settingsViewModifier.changeVolume() }
            .then(modifier),
        onDraw = {
            this.drawCircle(
                color = Color.White,
                radius = radius,
                center = this.center
            )


            this.drawCircle(
                color = if (settingsViewModifier.currentVolumeLevel >= 0) Color(0xFFC4F800) else Color.White,
                radius = smallRadius,
                center = Offset(center.x - radius, center.y + 200f),
            )

            this.drawCircle(
                color = if (settingsViewModifier.currentVolumeLevel >= 1) Color(0xFFC4F800) else Color.White,
                radius = smallRadius,
                center = Offset(center.x - radius - 80f, center.y),
            )

            this.drawCircle(
                color = if (settingsViewModifier.currentVolumeLevel >= 2) Color(0xFFC4F800) else Color.White,
                radius = smallRadius,
                center = Offset(center.x - radius, center.y - 180f),
            )

            this.drawCircle(
                color = if (settingsViewModifier.currentVolumeLevel >= 3) Color(0xFFC4F800) else Color.White,
                radius = smallRadius,
                center = Offset(center.x, center.y - 250),
            )

            this.drawCircle(
                color = if (settingsViewModifier.currentVolumeLevel >= 4) Color(0xFFC4F800) else Color.White,
                radius = smallRadius,
                center = Offset(center.x + radius, center.y - 180f),
            )

            this.drawCircle(
                color = if (settingsViewModifier.currentVolumeLevel >= 5) Color(0xFFC4F800) else Color.White,
                radius = smallRadius,
                center = Offset(center.x + radius + 80f, center.y),
            )

            this.drawCircle(
                color = if (settingsViewModifier.currentVolumeLevel >= 6) Color(0xFFC4F800) else Color.White,
                radius = smallRadius,
                center = Offset(center.x + radius, center.y + 200f),
            )

        },
    )

}


@Preview
@Composable
fun PreviewSettingsIndicator() {
    val viewModel = viewModel<SettingsViewModel>()
    SettingsVolumeIndicator(settingsViewModifier = viewModel, modifier = Modifier)
}