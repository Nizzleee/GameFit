package com.biosecure.gamefit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.biosecure.gamefit.ui.screens.*
import com.biosecure.gamefit.ui.theme.GamefitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GamefitTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GamefitApp()
                }
            }
        }
    }
}

@Composable
fun GamefitApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(onLoginSuccess = {
                navController.navigate("dashboard")
            })
        }
        composable("dashboard") {
            DashboardScreen(
                title = "Dashboard",
                stats = listOf(
                    Stat("VALIDACIONES HOY", "245"),
                    Stat("PREMIOS ENTREGADOS", "210"),
                    Stat("INVENTARIO DE LATAS", "75%"),
                    Stat("TOTEMS ACTIVOS", "1")
                ),
                onMenuClick = { /* Handle menu */ },
                onProfileClick = { navController.navigate("settings") },
                onScanClick = { navController.navigate("scanner") }
            )
        }
        composable("scanner") {
            ScannerScreen(
                onBack = { navController.popBackStack() },
                onScanSuccess = { navController.navigate("success") }
            )
        }
        composable("success") {
            SuccessScreen(onDismiss = {
                navController.popBackStack("dashboard", inclusive = false)
            })
        }
        composable("settings") {
            SettingsScreen(onBack = { navController.popBackStack() })
        }
    }
}
