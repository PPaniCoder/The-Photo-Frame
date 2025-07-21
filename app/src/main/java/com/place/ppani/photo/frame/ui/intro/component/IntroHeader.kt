package com.place.ppani.photo.frame.ui.intro.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.place.ppani.photo.frame.R


@Composable
fun IntroHeader() {
    Column {
        AppIconAnimated()

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.margin_large)))

        Text(
            text = stringResource(id = R.string.app_name),
            fontSize = dimensionResource(id = R.dimen.text_title).value.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.white),
            letterSpacing = (-0.5).sp
        )

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.margin_small)))

        Text(
            text = stringResource(id = R.string.app_subtitle),
            fontSize = dimensionResource(id = R.dimen.text_subtitle).value.sp,
            color = colorResource(id = R.color.white).copy(alpha = 0.9f),
            lineHeight = 24.sp
        )
    }
}