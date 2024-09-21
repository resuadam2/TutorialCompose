package com.resuadam2.listas

/**
 * Created by resuadam2 on september 2024.
 * Tutorial de Compose en Android
 * Basado en la lista de tutoriales de Mouredev y en la documentación oficial de Android sobre Compose
 * Main topics:
 * - Scroll
 * - Listas
 * - LazyColumn
 * - rememberScrollState
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
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
import com.resuadam2.listas.ui.theme.TutorialComposeTheme

// Partiremos del ejercicio anterior, disponible en el módulo modificadores de este mismo proyecto

//Crearemos una constante privada para almacenar una lista de nombres y poder probar la lista de elementos
private val names = listOf(
    FullName("Iago", "Aspas"),
    FullName("Vicente", "Guaita"),
    FullName("Tasos", "Douvikas"),
    FullName("Hugo","Álvarez"),
    FullName("Williot","Swedberg"),
    FullName("Hugo","Sotelo"),
    FullName("Fran","Beltrán"),
    FullName("Borja","Iglesias"),
    FullName("Pablo","Durán"),
    FullName("Carlos","Domínguez"),
    FullName("Óscar","Mingueza"),
    FullName("Alexander","Mostovoi"),
    FullName("Vlado","Gudelj"),
    FullName("Valery","Karpin"),
    FullName("Jose Manuel", "Pinto"),
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

@Composable
fun CustomText(text: String, color: Color, style: TextStyle = TextStyle.Default) {
    Text(
        text = text,
        color = color,
        style = style
    )
}

/**
 * Data class para almacenar el nombre y el apellido de una persona
 * @param name nombre de la persona
 * @param surname apellido de la persona
 * Así podemos pasar un objeto de tipo FullName a la función Greeting
 */
data class FullName(val name: String, val surname: String)

@Composable
fun Greeting(fullName: FullName) {
    Column(
        modifier = Modifier.padding(8.dp)
    ) {

        CustomText(
            text = "Hello ${fullName.name}!",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp)) // Spacer para añadir un espacio entre los elementos
        CustomText(text = "Goodbye ${fullName.surname}!", color = MaterialTheme.colorScheme.onBackground)
    }
}

// @Composable para definir una función composable
@Composable
fun RowContent(fullName: FullName) {
    Row ( // Row para mostrar los elementos de forma horizontal
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
    /** Utilizaremos LazyColumn para mostrar una lista de elementos de forma eficiente
     * LazyColumn es un componente que solo renderiza los elementos que son visibles en la pantalla
     * y los que están cerca de la pantalla para poder desplazar la lista de forma eficiente
     * Sustituye a Column y a ScrollView
     */
    LazyColumn { // LazyColumn para mostrar una lista de elementos de forma eficiente
        items(names) { name ->
            RowContent(name)
        }
    }
}


// @Preview para mostrar una vista previa de la actividad
@Preview(showSystemUi = true) // showSystemUI para mostrar la barra de estado y la barra de navegación
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
) // showBackground para mostrar el fondo de la vista previa Y uiMode para establecer el modo oscuro
@Composable // @Composable para definir una función composable
fun DefaultPreview() {
    TutorialComposeTheme { // TutorialComposeTheme para establecer el tema de la vista previa
        RowContent(names[0])
    }
}


/**
 * Comprobemos cómo se comporta la aplicación si añadimos una serie de elementos Row hasta
 * que la lista sea más larga que la pantalla, podemos probar el comportamiento iniciando desde la
 * esquina superior derecha del preview en el botón de "Run Preview"
 *
 * Probar después añadiendo el modificador verticalScroll para poder desplazar la lista
 */
@Preview(showSystemUi = true) // showSystemUI para mostrar la barra de estado y la barra de navegación
@Composable
fun RowsAsListPreview() {
    TutorialComposeTheme {
        // necesitamos un rememberScrollState para poder desplazar la lista verticalmente y que se muestre el contenido
        val scrollState = rememberScrollState()

        Column (
            // Añadimos el modificador verticalScroll para poder desplazar la lista verticalmente
            // modifier = Modifier.verticalScroll(scrollState)
        ){
            RowContent(names[0])
            RowContent(names[1])
            RowContent(names[2])
            RowContent(names[3])
            RowContent(names[4])
            RowContent(names[5])
            RowContent(names[6])
            RowContent(names[1])
            RowContent(names[0])
            RowContent(names[2])
            RowContent(names[8])
            RowContent(names[9])
            RowContent(names[0])
            RowContent(names[1])
            RowContent(names[5])
        }
    }
}

@Preview(showSystemUi = true) // showSystemUI para mostrar la barra de estado y la barra de navegación
@Composable
fun ListOfRowsPreview() {
    TutorialComposeTheme {
        ListOfRows(names = names)
    }
}