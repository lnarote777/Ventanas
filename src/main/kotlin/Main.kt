import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState


fun main() = application {
    val icon = BitmapPainter(useResource("sample.png", ::loadImageBitmap))
    val mainWindowState = rememberWindowState()
    var showMainWindow by remember { mutableStateOf(true) }

    if (showMainWindow){
        MainWindow(
            onClose = ,
            icon = icon,
            mainWindowState = mainWindowState
        )
    }
}

@Composable
@Preview
fun MainWindow(icon: BitmapPainter, mainWindowState: WindowState) {
    var showSecondWindow by remember { mutableStateOf(false) }
    Window(
        onCloseRequest = { showMainWindow = false },
        title = "Ventana Principal",
        icon = icon,
        state = mainWindowState
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(100.dp, Alignment.CenterVertically)
        ) {
            Text(text = "Ventana Principal")
            Button(onClick = {
                showSecondWindow = true

            }) {
                Text("Abrir Ventana Secundaria")
            }
        }

        if (showSecondWindow) {
            // Abrir la ventana secundaria
            SecondWindow(onClose = { showSecondWindow = false })
        }
    }
}

@Composable
fun SecondWindow(onClose: () -> Unit) {
    Window(
        onCloseRequest = onClose,
        title = "Ventana Secundaria"
    ) {
        Text("Este es el contenido de la ventana secundaria.")
    }
}

@Composable
fun MainContent(closeMain: () -> Unit){

}