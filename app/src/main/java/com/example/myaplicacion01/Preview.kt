package com.example.myaplicacion01

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.myaplicacion01.ui.theme.MyAplicacion01Theme

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyAplicacion01Theme {
        HydroregisScreen(navController = rememberNavController())
    }
}
