package com.miron.logisticquizfootball.presentaion.ui.el

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.miron.logisticquizfootball.R

@Composable
fun CustomCheckBox(isActive: Boolean, modifier: Modifier = Modifier)  {
    Box(modifier = Modifier.size(50.dp), contentAlignment = Alignment.Center){
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.White)
                .border(BorderStroke(1.dp, Color(0xFFC4F800)))
                .then(modifier),
        )
        if (isActive) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = null,
                modifier = Modifier.size(50.dp),
                tint = Color.Black
            )
        }
    }
}