package com.resuadam2.splash.navigation

/**
 * Definimos una clase sellada para representar las pantallas de la aplicación.
 * Cada pantalla tiene un nombre de ruta que se utilizará para la navegación.
 */

sealed class AppScreens(val route: String) {
    object MainScreen : AppScreens("main_screen")
    object SplashScreen : AppScreens("splash_screen")
}