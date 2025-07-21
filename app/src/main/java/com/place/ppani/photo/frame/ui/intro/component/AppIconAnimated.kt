package com.place.ppani.photo.frame.ui.intro.component

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.place.ppani.photo.frame.R

@Composable
fun AppIconAnimated() {
    val infiniteTransition = rememberInfiniteTransition()
    val offsetY by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = -10f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000),
            repeatMode = RepeatMode.Reverse
        ),
        label = "bounce"
    )

    val primaryGradientStart = colorResource(id = R.color.primary_gradient_start)
    val primaryGradientEnd = colorResource(id = R.color.primary_gradient_end)

    Box(
        modifier = Modifier
            .size(dimensionResource(id = R.dimen.app_icon_size))
            .offset(y = offsetY.dp)
            .shadow(
                dimensionResource(id = R.dimen.elevation_app_icon),
                RoundedCornerShape(dimensionResource(id = R.dimen.app_icon_radius))
            )
            .background(
                Brush.linearGradient(
                    colors = listOf(primaryGradientStart, primaryGradientEnd)
                ),
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.app_icon_radius))
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_app_icon),
            contentDescription = null,
            modifier = Modifier.size(dimensionResource(id = R.dimen.app_icon_content_size)),
            colorFilter = ColorFilter.tint(colorResource(id = R.color.white))
        )
    }
}