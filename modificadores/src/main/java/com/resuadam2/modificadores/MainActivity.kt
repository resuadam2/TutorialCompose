package com.resuadam2.modificadores

/**
 * Created by resuadam2 on september 2024.
 * Tutorial de Compose en Android
 * Basado en la lista de tutoriales de Mouredev y en la documentación oficial de Android sobre Compose
 * Main topics:
 * - Modificadores (Modifiers)
 * - CustomText
 * - Material Design
 * - Temas (Themes)
 * - ColorScheme
 * - Typography
 * - Padding
 * - Background
 * - Clip
 * - Size
 * - Spacer
 * - UI_MODE_NIGHT_YES
 */

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.resuadam2.modificadores.ui.theme.TutorialComposeTheme

// Partiremos del ejercicio anterior, disponible en el módulo introcompose de este mismo proyecto

class MainActivity : ComponentActivity() {
    // En el método onCreate, llamamos a la función enableEdgeToEdge para habilitar el modo de pantalla completa
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Habilitar el modo de pantalla completa
        setContent { // setContent para establecer el contenido de la actividad
            /**
             * Los temas también son elementos componibles, por lo que podemos envolver cualquier elemento componible con un tema
             * y también hay que tenerlo en cuenta en la jerarquía de componibles
             * Los temas están alojados en la carpeta ui/theme y se crean con la plantilla de Compose Theme
             * En la carpeta podéis encontrar el archivo Theme.kt con el tema de la aplicación
             * También el archivo Typography.kt con la tipografía de la aplicación
             * Y el archivo Color.kt con los colores de la aplicación
             * En el archivo Theme.kt, se definen los temas claro y oscuro
             * Y la función TutorialComposeTheme para establecer el tema de la aplicación
             * En el archivo Typography.kt, se definen los estilos de texto de la aplicación
             * En el archivo Color.kt, se definen los colores de la aplicación
             * El tema por defecto hereda de MaterialTheme que es el tema de Material Design, pero se puede cambiar
             * MaterialDesign es un sistema de diseño creado por Google que se utiliza en Android y en la web
             * Esto es importante para mantener la coherencia visual en la aplicación pero es un tema muy extenso
             */
            TutorialComposeTheme { // TutorialComposeTheme para establecer el tema de la actividad
                // Greeting para mostrar un saludo en la pantalla
                ScreenContent("Android")
            }
        }
    }
}

/**
 * Los modificadores son una forma de cambiar la apariencia de los elementos componibles
 * Se pueden aplicar a cualquier elemento componible
 * Hacemos que el customText tenga un color y un estilo de texto personalizado
 * Pero para la tipografía le damos un valor por defecto
 */
@Composable
fun CustomText(text: String, color: Color, style: TextStyle = TextStyle.Default) {
    Text(
        text = text,
        color = color, // Se suele dejar la coma ·,· al final de las propiedades para poder añadir más propiedades
        style = style
    )
}

// @Composable para definir una función composable
@Composable
fun Greeting(name: String) {
    Column( // Column para mostrar los elementos de forma vertical
        modifier = Modifier.padding(8.dp) // padding para añadir un relleno en todas las direcciones
    ) {

        CustomText(
            text = "Hello $name!",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp)) // Spacer para añadir un espacio entre los elementos
        CustomText(text = "Goodbye $name!", color = MaterialTheme.colorScheme.onBackground)
    }
}

// @Composable para definir una función composable
@Composable
fun ScreenContent(name: String) {
    Row ( // Row para mostrar los elementos de forma horizontal
        /**
         * moddifier para aplicar un modificador, este modificador se puede aplicar a cualquier elemento de la interfaz de usuario
         * le iremos añadiendo propiedades para modificar su aspecto como padding, tamaño, color, etc.
         * en kotlin, se pueden encadenar varios modificadores para aplicar varios cambios a la vez
         * padding para añadir un relleno en todas las direcciones
         * background para añadir un fondo de color
         * dependiendo del orden en el que se apliquen los modificadores, se aplicarán de una forma u otra
         */
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.inverseOnSurface)

    ){
        Image(

            /** El orden en el que se aplican los modificadores es importante, ya que se aplican de forma secuencial
             * como aplicamos el fondo antes de recortar la imagen, el fondo no se recorta
             * Sin embargo, el modificador size puede aplicarse en cualquier orden, esto depende del modificador
             */
            //modifier = Modifier.background(Color.Cyan).clip(shape = CircleShape),
            // Es más legible si separamos los modificadores en varias líneas
            modifier = Modifier
                .clip(shape = CircleShape)
                .background(MaterialTheme.colorScheme.primary)
                .size(64.dp),
            contentDescription = "Android Logo", // contentDescription para describir la imagen
            // painterResource para cargar una imagen desde los recursos (se debe importar androidx.compose.ui.res.painterResource)
            painter = painterResource(id = R.drawable.ic_launcher_foreground) // ic_launcher_foreground para cargar el icono de la aplicación
        )
        Greeting(name) // Greeting para mostrar un saludo en la pantalla
    }
}


// @Preview para mostrar una vista previa de la actividad
@Preview(showBackground = true) // showBackground para mostrar el fondo de la vista previa
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
) // showBackground para mostrar el fondo de la vista previa Y uiMode para establecer el modo oscuro
@Composable // @Composable para definir una función composable
fun DefaultPreview() {
    TutorialComposeTheme { // TutorialComposeTheme para establecer el tema de la vista previa
        ScreenContent("Android")
    }
}
