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
fun SecondWindow(showMainWindow: Boolean, showSecondWindow: Boolean, icon: BitmapPainter, windowState: WindowState, onClose: () -> Unit, onClick: () -> Unit) {
    if (showSecondWindow){
        Window(
            onCloseRequest = onClose,
            title = "Ventana Secundaria",
            icon = icon,
            state = windowState
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(100.dp, Alignment.CenterVertically)
            ) {
                Text(text = "VENTANA SECUNDARIA")
                Button(onClick = onClick) {
                    Text("Abrir Ventana Principal y cerrar esta")
                }
            }

            if (showMainWindow){
                MainWindow(showMainWindow, showSecondWindow, icon, windowState, onClose, onClick)
            }

        }
    }

}