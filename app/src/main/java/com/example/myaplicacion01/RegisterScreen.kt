package com.example.myaplicacion01

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavHostController) {
    val nombre = remember { mutableStateOf("") }
    val edad = remember { mutableStateOf("") }
    val telefono = remember { mutableStateOf("") }
    val correo = remember { mutableStateOf("") }
    val contrasena = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
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

        TextField(
            value = nombre.value,
            onValueChange = { nombre.value = it },
            placeholder = { Text("Nombre completo") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.LightGray,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = edad.value,
            onValueChange = { edad.value = it },
            placeholder = { Text("Edad") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.LightGray,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = telefono.value,
            onValueChange = { telefono.value = it },
            placeholder = { Text("Teléfono") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.LightGray,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = correo.value,
            onValueChange = { correo.value = it },
            placeholder = { Text("Correo electrónico") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.LightGray,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = contrasena.value,
            onValueChange = { contrasena.value = it },
            placeholder = { Text("Contraseña") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.LightGray,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { navController.navigate("login_screen") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = "Registrarse", color = Color.White, fontSize = 18.sp)
        }
    }
}
