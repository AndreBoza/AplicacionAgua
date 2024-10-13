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
fun ActividadesGeneralesScreen(navController: NavHostController) {
    // Lista mutable de actividades, comienza con 4 actividades por defecto
    val actividades = remember { mutableStateListOf("Actividad 1", "Actividad 2", "Actividad 3", "Actividad 4") }

    // Estado para controlar si se muestra el diálogo de edición
    var showEditDialog by remember { mutableStateOf(false) }
    var selectedActivityIndex by remember { mutableStateOf(-1) }
    var editedActivity by remember { mutableStateOf("") }

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
            actividades.forEachIndexed { index, actividad ->
                Row(modifier = Modifier.fillMaxWidth()) {
                    Button(
                        onClick = {
                            // Acción para editar actividad
                            selectedActivityIndex = index
                            editedActivity = actividad
                            showEditDialog = true
                        },
                        modifier = Modifier
                            .weight(1f)
                            .padding(vertical = 8.dp, horizontal = 4.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(text = actividad, color = Color.White, fontSize = 18.sp)
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = {
                            // Eliminar actividad
                            actividades.removeAt(index)
                        },
                        modifier = Modifier
                            .padding(vertical = 8.dp, horizontal = 4.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(text = "Eliminar", color = Color.White, fontSize = 14.sp)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botón para agregar una nueva actividad (máximo 10 actividades)
            Button(
                onClick = {
                    if (actividades.size < 10) {
                        actividades.add("Nueva Actividad ${actividades.size + 1}")
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
                shape = RoundedCornerShape(12.dp),
                enabled = actividades.size < 10 // Deshabilitar si hay más de 10 actividades
            ) {
                Text(text = "Agregar nueva actividad", color = Color.White, fontSize = 18.sp)
            }

            // Diálogo para editar una actividad
            if (showEditDialog) {
                AlertDialog(
                    onDismissRequest = { showEditDialog = false },
                    title = { Text(text = "Editar Actividad") },
                    text = {
                        TextField(
                            value = editedActivity,
                            onValueChange = { editedActivity = it },
                            label = { Text("Nombre de la actividad") }
                        )
                    },
                    confirmButton = {
                        Button(onClick = {
                            if (selectedActivityIndex != -1) {
                                actividades[selectedActivityIndex] = editedActivity
                                showEditDialog = false
                            }
                        }) {
                            Text("Guardar")
                        }
                    },
                    dismissButton = {
                        Button(onClick = { showEditDialog = false }) {
                            Text("Cancelar")
                        }
                    }
                )
            }
        }
    }
}
