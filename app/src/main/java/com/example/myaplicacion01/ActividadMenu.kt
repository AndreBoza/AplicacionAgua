package com.example.myaplicacion01

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActividadesGeneralesScreen(
    navController: NavHostController,
    actividades: MutableList<String> // Recibe la lista de actividades como parámetro
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Actividades Generales") }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            // Botones dinámicos basados en la lista de actividades
            actividades.forEach { actividad ->
                Button(
                    onClick = { /* Acción para cada actividad */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(text = actividad, color = Color.White, fontSize = 18.sp)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botón para agregar una nueva actividad (si quieres que se pueda seguir agregando desde esta pantalla)
            Button(
                onClick = {
                    actividades.add("Nueva Actividad ${actividades.size + 1}")
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(text = "Agregar nueva actividad", color = Color.White, fontSize = 18.sp)
            }
        }
    }
}
