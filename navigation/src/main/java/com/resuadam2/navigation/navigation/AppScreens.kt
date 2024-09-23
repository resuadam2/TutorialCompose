package com.resuadam2.navigation.navigation

/**
 * Definimos una clase sellada para representar las pantallas de la aplicación.
 * Cada pantalla tiene un nombre de ruta que se utilizará para la navegación.
 */

sealed class AppScreens(val route: String) {
    object FirstScreen : AppScreens("first_screen")
    object SecondScreen : AppScreens("second_screen")
}