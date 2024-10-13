package com.example.myaplicacion01

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FourthScreen(navController: NavHostController) {
    val expanded = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Menú") },
                navigationIcon = {
                    IconButton(onClick = { expanded.value = true }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menú")
                    }

                    // Menú desplegable con botones
                    DropdownMenu(
                        expanded = expanded.value,
                        onDismissRequest = { expanded.value = false }
                    ) {
                        // Botón de Perfil
                        Button(
                            onClick = {
                                expanded.value = false
                                navController.navigate("profile_screen")
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
                        ) {
                            Text("Perfil", color = Color.White, fontSize = 16.sp)
                        }

                        // Botón de Registro
                        Button(
                            onClick = {
                                expanded.value = false
                                // Acción de Registro aquí
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
                        ) {
                            Text("Registro", color = Color.White, fontSize = 16.sp)
                        }

                        // Botón para Agregar nueva actividad
                        Button(
                            onClick = {
                                expanded.value = false
                                navController.navigate("activividad_menu")
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
                        ) {
                            Text("Agregar nueva actividad", color = Color.White, fontSize = 16.sp)
                        }

                        // Botón de Tanque
                        Button(
                            onClick = {
                                expanded.value = false
                                // Acción para Tanque aquí
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
                        ) {
                            Text("Tanque", color = Color.White, fontSize = 16.sp)
                        }
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ppp),
                contentDescription = "Logo",
                modifier = Modifier.size(150.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))

            // Botón de Perfil
            Button(
                onClick = { navController.navigate("profile_screen") },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(text = "Perfil", color = Color.White, fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botón de Indicadores
            Button(
                onClick = { /* Acción del botón de Indicadores */ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(text = "Indicadores", color = Color.White, fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botón de Tanque
            Button(
                onClick = { navController.navigate("") },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(text = "Tanque", color = Color.White, fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Nuevo botón de Actividades Generales
            Button(
                onClick = { navController.navigate("actividades_generales") },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(text = "Actividades Generales", color = Color.White, fontSize = 18.sp)
            }
        }
    }
}
