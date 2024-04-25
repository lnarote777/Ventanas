
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState

@Composable
fun MainWindow(showMainWindow: Boolean, showSecondWindow: Boolean, icon: BitmapPainter, windowState: WindowState, onClose: () -> Unit, click: () -> Unit) {

    if (showMainWindow) {
        Window(
            onCloseRequest = onClose,
            title = "Ventana Principal",
            icon = icon,
            state = windowState
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(100.dp, Alignment.CenterVertically)
            ) {
                Text("VENTANA PRINCIPAL")
                Button(onClick = click) {
                    Text(text = "Abrir Ventana Secundaria y cerrar esta")
                }
            }

        }
    }

    if (showSecondWindow) {
        SecondWindow(showSecondWindow, showMainWindow, icon, windowState, onClose, click)
    }
}
