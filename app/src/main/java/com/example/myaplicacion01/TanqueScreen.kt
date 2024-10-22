package com.example.myaplicacion01

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun TanqueScreen(navController: NavController) {
    // Nivel máximo del tanque en litros
    val nivelMaximo = 1000f  // Ejemplo de 1000 litros de capacidad máxima

    // Estado para el nivel actual del tanque
    var nivelActual by remember { mutableStateOf(500f) }  // Inicial en 500 litros

    // Calcular el porcentaje de agua
    val porcentaje = (nivelActual / nivelMaximo) * 100

    // Interfaz de usuario
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Mostrar el porcentaje de agua
        Text(text = "Nivel de agua: ${porcentaje.toInt()}%")

        // Mostrar el nivel de agua en litros
        Text(text = "Cantidad de agua: ${nivelActual.toInt()} litros")

        Spacer(modifier = Modifier.height(20.dp))

        // Slider para ajustar el nivel de agua
        Slider(
            value = nivelActual,
            onValueChange = { nuevoNivel ->
                nivelActual = nuevoNivel
            },
            valueRange = 0f..nivelMaximo,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
