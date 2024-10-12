package com.example.myaplicacion01

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import android.widget.Toast
import androidx.compose.ui.draw.clip

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavHostController) {
    // Estados para gestionar los campos de texto
    var nombreUsuario by remember { mutableStateOf("Juan Pérez") }
    var correoUsuario by remember { mutableStateOf("juan.perez@correo.com") }
    var nuevaContrasena by remember { mutableStateOf("") }
    var confirmContrasena by remember { mutableStateOf("") }
    var nuevaFotoPerfil by remember { mutableStateOf(R.drawable.images) } // Foto de perfil por defecto
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Editar Perfil") },

            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Foto de perfil editable
            Image(
                painter = painterResource(id = nuevaFotoPerfil),
                contentDescription = "Foto de perfil",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de texto para editar el nombre de usuario
            TextField(
                value = nombreUsuario,
                onValueChange = { nombreUsuario = it },
                label = { Text("Nombre de usuario") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(containerColor = Color.LightGray)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de texto para editar el correo del usuario
            TextField(
                value = correoUsuario,
                onValueChange = { correoUsuario = it },
                label = { Text("Correo electrónico") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                colors = TextFieldDefaults.textFieldColors(containerColor = Color.LightGray)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de texto para la nueva contraseña
            TextField(
                value = nuevaContrasena,
                onValueChange = { nuevaContrasena = it },
                label = { Text("Nueva contraseña") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(containerColor = Color.LightGray)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de texto para confirmar la nueva contraseña
            TextField(
                value = confirmContrasena,
                onValueChange = { confirmContrasena = it },
                label = { Text("Confirmar nueva contraseña") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(containerColor = Color.LightGray)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Botón para guardar los cambios
            Button(
                onClick = {
                    if (nuevaContrasena == confirmContrasena) {
                        // Guardar los cambios
                        Toast.makeText(context, "Cambios guardados correctamente", Toast.LENGTH_SHORT).show()
                        // Navegar de vuelta a la FourthScreen
                        navController.navigate("fourth_screen") {
                            popUpTo("edit_profile_screen") { inclusive = true }
                        }
                    } else {
                        Toast.makeText(context, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
            ) {
                Text(text = "Guardar Cambios", color = Color.White, fontSize = 18.sp)
            }
        }
    }
}
