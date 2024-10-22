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
    // Lista mutable de actividades con su nombre y litros
    val actividades = remember {
        mutableStateListOf(
            Actividad("Actividad 1", 10),
            Actividad("Actividad 2", 20),
            Actividad("Actividad 3", 30),
            Actividad("Actividad 4", 40)
        )
    }

    // Estado para controlar si se muestra el diálogo de edición
    var showEditDialog by remember { mutableStateOf(false) }
    var selectedActivityIndex by remember { mutableStateOf(-1) }
    var editedActivityName by remember { mutableStateOf("") }
    var editedLitros by remember { mutableStateOf("") }

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
                    // Botón principal de la actividad
                    Button(
                        onClick = {
                            // Acciones al hacer clic en la actividad
                        },
                        modifier = Modifier
                            .weight(1f)
                            .padding(vertical = 8.dp, horizontal = 4.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(text = "${actividad.nombre} - ${actividad.litros} litros", color = Color.White, fontSize = 18.sp)
                    }

                    // Botón para editar la actividad
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = {
                            // Acción para editar actividad
                            selectedActivityIndex = index
                            editedActivityName = actividad.nombre
                            editedLitros = actividad.litros.toString()
                            showEditDialog = true
                        },
                        modifier = Modifier
                            .padding(vertical = 8.dp, horizontal = 4.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(text = "Editar", color = Color.Black, fontSize = 14.sp)
                    }

                    // Botón para eliminar la actividad
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
                        actividades.add(Actividad("Nueva Actividad ${actividades.size + 1}", 0))
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
                        Column {
                            // Campo para editar el nombre de la actividad
                            TextField(
                                value = editedActivityName,
                                onValueChange = { editedActivityName = it },
                                label = { Text("Nombre de la actividad") }
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            // Campo para editar los litros a usar
                            TextField(
                                value = editedLitros,
                                onValueChange = { editedLitros = it },
                                label = { Text("Litros a usar") }
                            )
                        }
                    },
                    confirmButton = {
                        Button(onClick = {
                            if (selectedActivityIndex != -1) {
                                // Actualizar el nombre y los litros de la actividad seleccionada
                                actividades[selectedActivityIndex].nombre = editedActivityName
                                actividades[selectedActivityIndex].litros = editedLitros.toIntOrNull() ?: 0
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

// Clase de datos para representar una actividad con nombre y litros
data class Actividad(var nombre: String, var litros: Int)
