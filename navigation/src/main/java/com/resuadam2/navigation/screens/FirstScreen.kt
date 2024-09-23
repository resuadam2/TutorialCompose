package com.resuadam2.navigation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.resuadam2.navigation.navigation.AppScreens

/**
 * Created by resuadam2 on september 2024.
 * First screen va a representar la primera pantalla de la aplicación
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen(navController: NavController) {
    /**
     * Vamos a añadir un Scafold que es un elemento de Material Design que nos permite
     * añadir una barra de herramientas, un contenido y un fondo
     */
    Scaffold (
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(), // Colores por defecto
                title = { Text("Primera pantalla") }) // Añadimos un título a la barra de herramientas
        },
    ) {
        // Añadimos el contenido de la pantalla
        BodyContent(
            // it es el padding que nos llega del Scaffold
            modifier = Modifier.padding(it),
            navController
        )
    }
}

@Composable
fun BodyContent(modifier: Modifier, navController: NavController) {
    // Añadimos el contenido de la pantalla
    Column (
        modifier = modifier.fillMaxSize(), // Rellenamos toda la pantalla
        verticalArrangement = Arrangement.Center, // Centramos el contenido
        horizontalAlignment = Alignment.CenterHorizontally, // Centramos el contenido
    ) {
        Text("Navegando")
        Button(onClick = {
            navController.navigate(route = AppScreens.SecondScreen.route + "/Esto es un parámetro") // Navegar a la segunda pantalla
        }) {
            Text("Navegar")
        }
    }
}