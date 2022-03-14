// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun BotonColor(onClick:() -> Unit) {
    var contador by remember { mutableStateOf(0) }
    var text by remember { mutableStateOf("Click me!") }

    MaterialTheme {
        Button(onClick = onClick) {
            Text(text)
        }
    }
}

@Composable
fun BotonIcono(){

}


fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Prueba") {
        var color by remember { mutableStateOf(Color.White) }
        Surface(
            color = color,
            modifier = Modifier.fillMaxSize()
        ) {
            Row(verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.Start) {
                Icon(painterResource(resourcePath = "Estilo-Jetpack-Compose-Android.png"),"Hecho con Compose",
                    modifier = Modifier.size(Dp(30.0F),Dp(30.0F)))

            }

            Row(verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.Center) {
                Text(color = Color.White,text = "Texto secreto ;)")
            }

            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                BotonColor {
                    color = setOf(
                        Color.White,
                        Color.Blue,
                        Color.Black,
                        Color.Cyan,
                        Color.Gray,
                        Color.DarkGray,
                        Color.Green,
                        Color.LightGray,
                        Color.Magenta,
                        Color.Red,
                        Color.Yellow
                    ).random()
                }
            }
        }
    }
}

