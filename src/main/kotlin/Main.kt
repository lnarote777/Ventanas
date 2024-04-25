
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState


fun main() = application {
    var showMainWindow by remember { mutableStateOf(true) }
    var showSecondWindow by remember { mutableStateOf(false) }
    val icon = BitmapPainter(useResource("sample.png", ::loadImageBitmap))
    val windowState = rememberWindowState()

    if (showMainWindow && !showSecondWindow){
        MainWindow(
            showMainWindow,
            showSecondWindow,
            icon,
            windowState,
            {exitApplication()},
            {showMainWindow = false; showSecondWindow = true}
        )
    }else{
        SecondWindow(
            showMainWindow,
            showSecondWindow,
            icon,
            windowState,
            {exitApplication()},
            {showMainWindow = true; showSecondWindow = false}
        )
    }

}