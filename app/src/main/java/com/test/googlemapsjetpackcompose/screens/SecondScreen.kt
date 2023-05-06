@file:OptIn(ExperimentalMaterial3Api::class)

package com.test.googlemapsjetpackcompose.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.test.googlemapsjetpackcompose.navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SecondScreen(navController: NavController, text: String?) {
    Scaffold { SecondBodyContent(navController, text) }
}

@Composable
fun SecondBodyContent(navController: NavController, avatarId: String?) {
    Column(
        // El hijo ocupará todo el espacio disponible.
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        // Los hijos se colocan en la parte inferior.
        verticalArrangement = Arrangement.Bottom,
        // Los hijos se centran horizontalmente.
        horizontalAlignment = Alignment.Start
    ) {
        Row {
            // Muestra la imagen utilizando el avatarId
            if (avatarId != null) {
                Box(modifier = Modifier.padding(start = 10.dp, top = 30.dp)) {
                    Image(
                        painter = painterResource(id = avatarId.toInt()),
                        contentDescription = "avatar",
                        modifier = Modifier
                            .width(150.dp)
                            .height(150.dp)
                            .align(Alignment.TopStart)
                    )
                }
            }

            // Agrega el texto al lado derecho de la imagen y lo centra verticalmente
            Box(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = "Perro Callejero",
                    color = Color.White,
                    fontSize = 25.sp
                )
            }
        }

        // Añade un espacio flexible para empujar el botón hacia abajo
        Spacer(modifier = Modifier.weight(1f))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    navController.navigate(route = AppScreens.MapScreen.route)
                },
                modifier = Modifier
                    // Centrar el botón horizontalmente
                    .width(200.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                // El texto que se muestra en el botón.
                Text("ABRIR MAPA", fontSize = 20.sp)
            }
            // Añade un espacio entre el botón y el borde inferior de la pantalla.
            Spacer(modifier = Modifier.height(60.dp))
        }
    }
}
