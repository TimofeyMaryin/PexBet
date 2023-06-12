package com.miron.logisticquizfootball.presentaion.fr.first_level

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.miron.logisticquizfootball.presentaion.ui.el.CustomCheckBox

@Composable
fun FirstLevelGameEl(
    modifier: Modifier,
    imageSrc: Int,
    isActive: Boolean,
    onClick: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .clickable { onClick() }
            .then(modifier)
    ) {
        Image(
            painter = painterResource(id = imageSrc),
            contentDescription = null,
            modifier = Modifier.size(100.dp),
            contentScale = ContentScale.Crop
        )
        CustomCheckBox(isActive = isActive)
    }
}