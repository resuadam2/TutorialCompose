package com.resuadam2.navigation.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.resuadam2.navigation.screens.FirstScreen
import com.resuadam2.navigation.screens.SecondScreen

/**
 * Para poder navegar entre pantallas, necesitamos un componente que nos permita hacerlo.
 * Vamos a crear un componente que se encargue de la navegación de la aplicación.
 * Para ello, necesitamos añadir una dependencia de Compose Navigation.
 * Añadimos la dependencia en el archivo build.gradle (Module: "Nombre del módulo")
 * en la sección de dependencies:
 *  val nav_version = "2.8.1" o la última versión disponible
 *
 * implementation("androidx.navigation:navigation-compose:$nav_version")
 */

@ExperimentalMaterial3Api
@Composable
fun AppNavigation() {
    /**
     * Para poder navegar entre pantallas, necesitamos un NavController.
     * El NavController es el encargado de gestionar la navegación de la aplicación.
     * Para ello, utilizamos la función rememberNavController() que nos proporciona
     * Navigation Compose. Esta función nos devuelve un NavController que podemos
     * utilizar para navegar entre pantallas.
     */
    val navController = rememberNavController()

    // Añadimos el componente NavHost que se encargará de la navegación de la aplicación
    NavHost(navController = navController, startDestination = AppScreens.FirstScreen.route) {
        // Añadimos las pantallas de la aplicación
        composable(AppScreens.FirstScreen.route) {
            // Añadimos la primera pantalla
            FirstScreen(navController)
        }
        composable(AppScreens.SecondScreen.route + "/{text}", arguments = listOf(navArgument(name = "text") {
            type = NavType.StringType
        })) {
            // Añadimos la segunda pantalla y pasamos el argumento a la pantalla en caso de que lo haya
            SecondScreen(navController, it.arguments?.getString("text")) // Pasamos el argumento a la segunda pantalla
        }
    }

}