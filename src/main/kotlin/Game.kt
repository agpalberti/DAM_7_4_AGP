import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

@Composable
@Preview
fun BotonPlay(onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Image(painterResource("play.png"), "Play")
    }
}

@Composable
fun BotonExit(onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Image(painterResource("exit.png"), "Exit")
    }
}

@Composable
fun BotonText(text:String, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(text)
    }
}

@OptIn(ExperimentalComposeUiApi::class)
fun main() = application {
    var play by remember { mutableStateOf(false) }
    Window(onCloseRequest = ::exitApplication,
        resizable = false,
        title = "1 DAM Battlegrounds",
        state = WindowState(isMinimized = false, height = Dp(704F), width = Dp(1080F)),
        icon = painterResource("icon.png")) {
        if (!play) {
            Surface(modifier = Modifier.fillMaxSize(), color = Color.Black) {
                Image(painterResource("fondo.png"), "Fondo")
                Row(horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.Top,
                    modifier = Modifier.padding(Dp(40F))) {
                    Image(painterResource("pokemonlogo.png"), "Pokemon")
                }

                Row(horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(Dp(90F))) {
                    BotonPlay { play = true }
                }

                Row(horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier.padding(Dp(150F))) {
                    BotonExit(onClick = ::exitApplication)
                }
                Row(horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier.padding(Dp(10f))) {
                    Text("Made by AGP ??")
                }
            }
        } else {
            var attack by remember { mutableStateOf(false) }
            var defender by remember { mutableStateOf(false) }
            Surface(color = Color.Black, modifier = Modifier
                .fillMaxSize()
                .onKeyEvent {
                    when(it.key){
                        Key.A -> {attack = true;print("Hola");true}
                        Key.D -> {defender = true;true}
                        else -> false
                    }
                }) {
                Image(painterResource("bosque.png"), "Fondo bosque")
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Bottom,
                ) {
                    Image(painterResource("singlesprite.png"), "Trainer", modifier = Modifier.width(Dp(300F)))
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Bottom) {
                    Row{BotonText("Atacar") { attack = true }}
                    Row{BotonText("Defender"){defender = true} }
                }
                Column(horizontalAlignment = Alignment.End, verticalArrangement = Arrangement.Top) {
                    if (!attack) {
                        Image(painterResource("edu.png"), "Edu")
                    } else Image(painterResource("img.png"), "Explosion")
                }
            }
        }
    }
}




















































































