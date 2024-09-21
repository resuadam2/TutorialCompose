package com.resuadam2.state

/**
 * Created by resuadam2 on september 2024.
 * Tutorial de Compose en Android
 * Basado en la lista de tutoriales de Mouredev y en la documentación oficial de Android sobre Compose
 * Main topics:
 * - Estado (State)
 * //TODO: Añadir más temas y completar el ejemplo
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
import com.resuadam2.state.ui.theme.TutorialComposeTheme

// Partiremos del ejercicio anterior, disponible en el módulo listas de este mismo proyecto

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

