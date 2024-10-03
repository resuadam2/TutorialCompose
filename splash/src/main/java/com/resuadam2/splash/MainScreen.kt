package com.resuadam2.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainScreen() {
    Column (
        modifier = Modifier.fillMaxSize(), // Rellenamos toda la pantalla
        verticalArrangement = Arrangement.Center, // Centramos el contenido
        horizontalAlignment = Alignment.CenterHorizontally, // Centramos el contenido
    ) {
        Text("Pantalla principal de la app")
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}