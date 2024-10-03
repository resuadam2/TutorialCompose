package com.resuadam2.splash

/**
 *  * Created by resuadam2 on september 2024.
 *  * Tutorial de Compose en Android
 *  * Basado en la lista de tutoriales de Mouredev y en la documentación oficial de Android sobre Compose
 *  * Main topics:
 *  - Splash Screen
 *  - Navigation
 *  - Launched Effect
 *  - Composable functions
 *  - Coroutines
 *  - Delay
 */

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.resuadam2.splash.navigation.AppNavigation
import com.resuadam2.splash.ui.theme.TutorialComposeTheme

/**
 * La forma más sencilla de crear una splash screen con Jetpack Compose es crear una vista para
 * la splash y otra para la principal, y haremos una navegación de la primera a la segunda tras
 * un tiempo determinado.
 * Desde Android 12 podemos crear una splash screen con la API SplashScreen, pero no es tan
 * personalizable como la que vamos a crear, tan solo muestra un fondo y un icono. Además,
 * la API SplashScreen no es compatible con versiones anteriores a Android 12.
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TutorialComposeTheme {
                AppNavigation()
            }
        }
    }
}
