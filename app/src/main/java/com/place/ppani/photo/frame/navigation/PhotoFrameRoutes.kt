package com.place.ppani.photo.frame.navigation

sealed class PhotoFrameRoutes(val route: String) {
    object Intro : PhotoFrameRoutes("intro")
    object Main : PhotoFrameRoutes("main")
}
