package com.place.ppani.photo.frame.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.place.ppani.photo.frame.ui.intro.IntroScreen
import com.place.ppani.photo.frame.ui.main.MainScreen

@Composable
fun PhotoFrameNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = PhotoFrameRoutes.Intro.route
    ) {
        composable(PhotoFrameRoutes.Intro.route) {
            IntroScreen(
                onNavigateToMain = {
                    navController.navigate(PhotoFrameRoutes.Main.route) {
                        popUpTo(PhotoFrameRoutes.Intro.route) { inclusive = true }
                    }
                }
            )
        }

        composable(PhotoFrameRoutes.Main.route) {
            MainScreen()
        }
    }
}