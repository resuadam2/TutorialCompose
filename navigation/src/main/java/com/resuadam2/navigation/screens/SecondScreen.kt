package com.resuadam2.navigation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

/**
 * Created by resuadam2 on september 2024.
 * Second screen va a representar la segumda pantalla de la aplicación
 */

// Anotación para indicar que estamos utilizando una API experimental
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondScreen(navController: NavController, text: String?) {

    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text("Segunda pantalla") },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Volver",
                        modifier = Modifier.clickable{ // Hacer clic en el icono
                            navController.popBackStack() // Volver a la pantalla anterior
                        }
                    )
                }
            )
        },
    ) {
        // Añadimos el contenido de la pantalla
        SecondBodyContent(
            modifier = Modifier.padding(it),
            navController,
            text
        )
    }
}

@Composable
fun SecondBodyContent(modifier: Modifier, navController: NavController, text: String?) {
    Column (
        modifier = modifier.fillMaxSize(), // Rellenamos toda la pantalla
        verticalArrangement = Arrangement.Center, // Centramos el contenido
        horizontalAlignment = Alignment.CenterHorizontally, // Centramos el contenido
    ) {
        Text("He navegado a la segunda pantalla")
        /**
         * Vamos a añadir un Text que nos muestre el texto que hemos pasado como argumento
         * a la segunda pantalla. Para ello, vamos a añadir un Text que muestre el texto
         * que hemos pasado como argumento.
         * let es una función de extensión que nos permite ejecutar un bloque de código
         * si el valor no es nulo.
         */
        text?.let {
            Text("Texto: $it") // it es el texto que hemos pasado como argumento
        }
        Button(onClick = {
            navController.popBackStack() // Volver a la pantalla anterior
        }) {
            Text("Volver")
        }
    }
}