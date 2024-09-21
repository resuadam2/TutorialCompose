package com.resuadam2.tutorialcompose

/**
 * Created by resuadam2 on 31/01/2022.
 * Tutorial de Compose en Android
 * Basado en la lista de tutoriales de Mouredev y en la documentación oficial de Android sobre Compose
 * Main topics:
 * - Column
 * - Row
 * - Image
 * - setContent
 * - @Composable
 * - @Preview
 * - painterResource
 * - enableEdgeToEdge
 */

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.resuadam2.tutorialcompose.ui.theme.TutorialComposeTheme

// Partimos de un proyecto con la plantilla de Compose Activity
class MainActivity : ComponentActivity() {
    // En el método onCreate, llamamos a la función enableEdgeToEdge para habilitar el modo de pantalla completa
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Habilitar el modo de pantalla completa
        setContent { // setContent para establecer el contenido de la actividad
            TutorialComposeTheme { // TutorialComposeTheme para establecer el tema de la actividad
                    // Greeting para mostrar un saludo en la pantalla
                    ScreenContent("Android")
            }
        }
    }
}

// @Composable para definir una función composable
// Si mostramos dos Text juntos, se superpondrán
@Composable
fun GreetingBad(name: String) {
    Text(text = "Hello $name!") // Text para mostrar un texto en la pantalla
    Text(text = "Goodbye $name!")
}

// @Composable para definir una función composable
@Composable
fun GreetingGood(name: String) {
    Column {
        Text(text = "Hello $name!") // Text para mostrar un texto en la pantalla
        Text(text = "Goodbye $name!")
    }
}

// @Composable para definir una función composable
@Composable
fun Greeting(name: String) {
    Column( // Column para mostrar los elementos de forma vertical
    ) {
        Text(text = "Hello $name!") // Text para mostrar un texto en la pantalla
        Text(text = "Goodbye $name!")
    }
}

// @Composable para definir una función composable
@Composable
fun ScreenContent(name: String) {
    Row ( // Row para mostrar los elementos de forma horizontal
    ){
        Image(
            contentDescription = "Android Logo", // contentDescription para describir la imagen
            // painterResource para cargar una imagen desde los recursos (se debe importar androidx.compose.ui.res.painterResource)
            painter = painterResource(id = R.drawable.ic_launcher_foreground) // ic_launcher_foreground para cargar el icono de la aplicación
        )
        Greeting(name) // Greeting para mostrar un saludo en la pantalla
    }
}


// @Preview para mostrar una vista previa de la actividad
@Preview(showBackground = true) // showBackground para mostrar el fondo de la vista previa
@Composable // @Composable para definir una función composable
fun DefaultPreview() {
    TutorialComposeTheme { // TutorialComposeTheme para establecer el tema de la vista previa
        // Greeting para mostrar un saludo en la vista previa
        // GreetingBad("Android")
        // GreetingGood("Android")
        // Greeting("Android")
        ScreenContent("Android")
    }
}
