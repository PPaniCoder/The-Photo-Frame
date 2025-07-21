package com.place.ppani.photo.frame.ui.intro.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.place.ppani.photo.frame.R

@Composable
fun FeaturesCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.white)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_card))
        ) {
            FeatureItem(
                icon = R.drawable.ic_gallery,
                title = stringResource(id = R.string.feature_gallery_title),
                description = stringResource(id = R.string.feature_gallery_desc),
                delay = 0
            )

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.feature_item_spacing)))

            FeatureItem(
                icon = R.drawable.ic_check_circle,
                title = stringResource(id = R.string.feature_effects_title),
                description = stringResource(id = R.string.feature_effects_desc),
                delay = 200
            )

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.feature_item_spacing)))

            FeatureItem(
                icon = R.drawable.ic_star,
                title = stringResource(id = R.string.feature_favorites_title),
                description = stringResource(id = R.string.feature_favorites_desc),
                delay = 400
            )
        }
    }
}