package com.resuadam2.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.resuadam2.splash.navigation.AppScreens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    // Simulamos una carga de 2 segundos
    LaunchedEffect(key1 = true) {
        delay(2000) // 2 segundos de carga simulada
        navController.popBackStack() // Eliminamos la pantalla de carga
        navController.navigate(AppScreens.MainScreen.route)
    }
    Splash()
}

@Composable
fun Splash() {
    // Pantalla de carga
    Column (
        modifier = Modifier.fillMaxSize(), // Rellenamos toda la pantalla
        horizontalAlignment = Alignment.CenterHorizontally, // Centramos el contenido
        verticalArrangement = Arrangement.Center, // Centramos el contenido
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Logo de la app",
            modifier = Modifier
                .size(128.dp)
                .clip(shape = RoundedCornerShape(32.dp))
                .background(Color.Cyan)
        )
        Spacer(modifier = Modifier.size(16.dp))
        Text("Cargando...")
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    Splash()
}