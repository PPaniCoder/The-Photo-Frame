package com.place.ppani.photo.frame.ui.intro.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.place.ppani.photo.frame.R

@Composable
fun PermissionNoticeCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.background_light)
        )
    ) {
        Column(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_card))
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.permission_icon_size))
                        .background(
                            colorResource(id = R.color.primary_gradient_start),
                            shape = RoundedCornerShape(8.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_lock),
                        contentDescription = null,
                        modifier = Modifier.size(dimensionResource(id = R.dimen.permission_icon_content_size)),
                        colorFilter = ColorFilter.tint(colorResource(id = R.color.white))
                    )
                }

                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.margin_small)))

                Text(
                    text = stringResource(id = R.string.permission_title),
                    fontSize = dimensionResource(id = R.dimen.text_subtitle).value.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.text_primary)
                )
            }

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.margin_small)))

            Text(
                text = stringResource(id = R.string.permission_desc),
                fontSize = dimensionResource(id = R.dimen.text_body).value.sp,
                color = colorResource(id = R.color.text_tertiary),
                lineHeight = 20.sp
            )
        }
    }
}