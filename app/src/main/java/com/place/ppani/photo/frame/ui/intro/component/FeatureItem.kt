package com.place.ppani.photo.frame.ui.intro.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.place.ppani.photo.frame.R
import kotlinx.coroutines.delay

@Composable
fun FeatureItem(
    icon: Int,
    title: String,
    description: String,
    delay: Int
) {
    var visible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(delay.toLong())
        visible = true
    }

    AnimatedVisibility(
        visible = visible,
        enter = slideInHorizontally(initialOffsetX = { -50 }) + fadeIn()
    ) {
        Row {
            Box(
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.feature_icon_size))
                    .background(
                        colorResource(id = R.color.background_light),
                        shape = RoundedCornerShape(12.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    modifier = Modifier.size(dimensionResource(id = R.dimen.feature_icon_content_size))
                )
            }

            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.margin_medium)))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    fontSize = dimensionResource(id = R.dimen.text_subtitle).value.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.text_primary)
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = description,
                    fontSize = dimensionResource(id = R.dimen.text_body).value.sp,
                    color = colorResource(id = R.color.text_secondary),
                    lineHeight = 20.sp
                )
            }
        }
    }
}