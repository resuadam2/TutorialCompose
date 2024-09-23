package com.resuadam2.state

/**
 * Created by resuadam2 on september 2024.
 * Tutorial de Compose en Android
 * Basado en la lista de tutoriales de Mouredev y en la documentación oficial de Android sobre Compose
 * Main topics:
 * - Estado (State)
 * - remember
 * - mutableStateOf
 */


import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.resuadam2.state.ui.theme.TutorialComposeTheme

// Partiremos del ejercicio anterior, disponible en el módulo listas de este mismo proyecto

//Crearemos una constante privada para almacenar una lista de nombres y poder probar la lista de elementos
private val names = listOf(
    FullName("Iago", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas leo elit, condimentum ut vulputate sed, blandit ut metus. Mauris erat tellus, rhoncus faucibus rhoncus eu, mollis vel purus. Lorem ipsum dolor sit amet, consectetur adipiscing elit."),
    FullName("Vicente", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "),
    FullName("Tasos", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "),
    FullName("Hugo","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas leo elit, condimentum ut vulputate sed, blandit ut metus. Mauris erat tellus, rhoncus faucibus rhoncus eu, mollis vel purus. Lorem ipsum dolor sit amet, consectetur adipiscing elit."),
    FullName("Williot","Lorem ipsum dolor sit amet, consectetur adipiscing elit. "),
    FullName("Hugo","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas leo elit, condimentum ut vulputate sed, blandit ut metus. Mauris erat tellus, rhoncus faucibus rhoncus eu, mollis vel purus. "),
    FullName("Fran","Lorem ipsum dolor sit amet, consectetur adipiscing elit. "),
    FullName("Borja","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas leo elit, condimentum ut vulputate sed, blandit ut metus. Mauris erat tellus, rhoncus faucibus rhoncus eu, mollis vel purus. "),
    FullName("Pablo","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas leo elit, condimentum ut vulputate sed, blandit ut metus. Mauris erat tellus, rhoncus faucibus rhoncus eu, mollis vel purus. "),
    FullName("Carlos","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas leo elit, condimentum ut vulputate sed, blandit ut metus. Mauris erat tellus, rhoncus faucibus rhoncus eu, mollis vel purus. "),
    FullName("Óscar","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas leo elit, condimentum ut vulputate sed, blandit ut metus. Mauris erat tellus, rhoncus faucibus rhoncus eu, mollis vel purus. "),
    FullName("Alexander","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas leo elit, condimentum ut vulputate sed, blandit ut metus. Mauris erat tellus, rhoncus faucibus rhoncus eu, mollis vel purus. "),
    FullName("Vlado","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas leo elit, condimentum ut vulputate sed, blandit ut metus. Mauris erat tellus, rhoncus faucibus rhoncus eu, mollis vel purus. "),
    FullName("Valery","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas leo elit, condimentum ut vulputate sed, blandit ut metus. Mauris erat tellus, rhoncus faucibus rhoncus eu, mollis vel purus. "),
    FullName("Jose Manuel", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas leo elit, condimentum ut vulputate sed, blandit ut metus. Mauris erat tellus, rhoncus faucibus rhoncus eu, mollis vel purus. "),
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TutorialComposeTheme {
                ListOfRows(names = names)
            }
        }
    }
}

// Añadimos a nuestro CustomText un parámetro lines para indicar el número de líneas que queremos mostrar
@Composable
fun CustomText(text: String, color: Color, style: TextStyle = TextStyle.Default, lines: Int = Int.MAX_VALUE) {
    Text(
        text = text,
        color = color,
        style = style,
        maxLines = lines
    )
}

data class FullName(val name: String, val text: String)

/**
 * Jetpack Compose funciona de manera estática, mediante programación reactiva y funcional.
 * Esto significa que los elementos componibles no cambian su estado una vez creados.
 * Debemos tener definido la totalidad del contexta de la UI antes de ejecutar la aplicación.
 * Por tanto, no podemos utilizar variales que muten en tiempo de ejecución.
 * Para almacenar estados en funciones componibles necesitaremos utilizar remember.
 * Esto nos permitirá almacenar valores en una variable dentro del contexto de la función componible.
 */

@Composable
fun Greeting(fullName: FullName) {

    // var expanded = false // no nos sirve dentro del contexto de compose
    var expanded by remember { mutableStateOf(false) } // Variable para controlar si el texto está expandido o no

    Column(
        // Añadimos al modificador de la columna la propiedad clickable para hacer que el elemento sea clickeable
        modifier = Modifier.padding(8.dp).clickable {
            expanded = !expanded // Cambiamos el valor de la variable al hacer click
        }
    ) {

        CustomText(
            text = "Hello ${fullName.name}!",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp)) // Spacer para añadir un espacio entre los elementos
        CustomText(
            text = "Goodbye ${fullName.text}!",
            color = MaterialTheme.colorScheme.onBackground,
            lines = if (expanded) Int.MAX_VALUE else 2 // Si expanded es true, mostramos todas las líneas, si no, mostramos solo 2
            )
    }
}

@Composable
fun RowContent(fullName: FullName) {
    Row (
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.inverseOnSurface)

    ){
        Image(
            modifier = Modifier
                .clip(shape = CircleShape)
                .background(MaterialTheme.colorScheme.primary)
                .size(64.dp),
            contentDescription = "Android Logo", // contentDescription para describir la imagen
            // painterResource para cargar una imagen desde los recursos (se debe importar androidx.compose.ui.res.painterResource)
            painter = painterResource(id = R.drawable.ic_launcher_foreground) // ic_launcher_foreground para cargar el icono de la aplicación
        )
        Greeting(fullName) // Greeting para mostrar un saludo en la pantalla
    }
}

@Composable
fun ListOfRows(names: List<FullName>) {
    LazyColumn {
        items(names) { name ->
            RowContent(name)
        }
    }
}


@Preview(showSystemUi = true)
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun DefaultPreview() {
    TutorialComposeTheme {
        ListOfRows(names = names)
    }
}

