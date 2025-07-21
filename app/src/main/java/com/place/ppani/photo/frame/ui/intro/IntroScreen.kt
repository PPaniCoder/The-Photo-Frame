package com.place.ppani.photo.frame.ui.intro

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.place.ppani.photo.frame.R
import com.place.ppani.photo.frame.ui.intro.component.FeaturesCard
import com.place.ppani.photo.frame.ui.intro.component.IntroHeader
import com.place.ppani.photo.frame.ui.intro.component.PermissionDeniedDialog
import com.place.ppani.photo.frame.ui.intro.component.PermissionNoticeCard
import com.place.ppani.photo.frame.ui.intro.component.PermissionRationaleDialog
import com.place.ppani.photo.frame.ui.intro.component.StartButton

@Composable
fun IntroScreen(
    onNavigateToMain: () -> Unit
) {
    val context = LocalContext.current
    var showRationaleDialog by remember { mutableStateOf(false) }
    var showDeniedDialog by remember { mutableStateOf(false) }

    // Permission launcher
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            onNavigateToMain()
        } else {
            showDeniedDialog = true
        }
    }

    // Colors from resources
    val primaryGradientStart = colorResource(id = R.color.primary_gradient_start)
    val primaryGradientEnd = colorResource(id = R.color.primary_gradient_end)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    colors = listOf(primaryGradientStart, primaryGradientEnd)
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(dimensionResource(id = R.dimen.padding_screen))
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            IntroHeader()

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.margin_xlarge)))

            FeaturesCard()

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.margin_large)))

            PermissionNoticeCard()

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.margin_large)))

            StartButton(
                onClick = {
                    when (ContextCompat.checkSelfPermission(
                        context,
                        Manifest.permission.READ_EXTERNAL_STORAGE
                    )) {
                        PackageManager.PERMISSION_GRANTED -> {
                            onNavigateToMain()
                        }
                        else -> {
                            if (context is androidx.activity.ComponentActivity) {
                                if (context.shouldShowRequestPermissionRationale(
                                        Manifest.permission.READ_EXTERNAL_STORAGE
                                    )) {
                                    showRationaleDialog = true
                                } else {
                                    permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
                                }
                            }
                        }
                    }
                }
            )
        }
    }

    // Dialogs
    if (showRationaleDialog) {
        PermissionRationaleDialog(
            onDismiss = { showRationaleDialog = false },
            onConfirm = {
                showRationaleDialog = false
                permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
            }
        )
    }

    if (showDeniedDialog) {
        PermissionDeniedDialog(
            onDismiss = { showDeniedDialog = false }
        )
    }
}