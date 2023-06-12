package com.miron.logisticquizfootball.presentaion.modifiers

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import com.miron.logisticquizfootball.presentaion.Utils
import com.miron.logisticquizfootball.presentaion.navigation.Screen

fun Modifier.styleHomeButton(onClick: () -> Unit) = then(
    Modifier.clickable { onClick() }.height(Utils.sizeMenuButton).padding(bottom = Utils.marginUntilButton)
)