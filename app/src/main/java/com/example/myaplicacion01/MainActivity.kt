package com.example.myaplicacion01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myaplicacion01.ui.theme.MyAplicacion01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAplicacion01Theme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "login") {
                    // Pantallas existentes
                    composable("login") {
                        HydroregisScreen(navController = navController)
                    }
                    composable("login_screen") {
                        LoginScreen(navController = navController)
                    }
                    composable("register") {
                        RegisterScreen(navController = navController)
                    }
                    composable("fourth_screen") {
                        FourthScreen(navController = navController)
                    }
                    composable("profile_screen") {
                        ProfileScreen(navController = navController)
                    }
                    composable("activividad_menu") {
                        ActividadesGeneralesScreen(navController = navController)
                    }
                    composable("actividades_generales") {
                        ActividadesGeneralesScreen(navController = navController)
                    }

                    // Nuevo destino: TanqueScreen
                    composable("tanque_screen") {
                        TanqueScreen(navController = navController)
                    }
                }
            }
        }
    }
}
