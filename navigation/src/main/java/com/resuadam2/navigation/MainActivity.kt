package com.resuadam2.navigation
/**
 * Created by resuadam2 on september 2024.
 * Tutorial de Compose en Android
 * Basado en la lista de tutoriales de Mouredev y en la documentación oficial de Android sobre Compose
 * Main topics:
 * - Navegación (Navigation)
 * (see package screens)
 * - Scaffold (see package screens)
 * - topBar
 * - modifier
 * - fillMaxSize
 * - verticalArrangement
 * - horizontalAlignment
 * - clickables
 * - popBackStack
 * - arguments
 * - arrowBack
 * - optional material3 experimental API
 * - navHostController
 * - navHost
 *
 */

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.resuadam2.navigation.navigation.AppNavigation
import com.resuadam2.navigation.ui.theme.TutorialComposeTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
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

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun GreetingPreview() {
    TutorialComposeTheme {
        AppNavigation()
    }
}