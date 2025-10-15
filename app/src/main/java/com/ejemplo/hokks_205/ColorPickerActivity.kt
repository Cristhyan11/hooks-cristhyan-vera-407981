package com.ejemplo.activityresults

import android.os.Bundle
import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

class ColorPickerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColorPickerScreen { colorName, colorValue ->
                val resultIntent = Intent()
                resultIntent.putExtra(MainActivity.RAINBOW_COLOR_NAME, colorName)
                resultIntent.putExtra(MainActivity.RAINBOW_COLOR, colorValue)
                setResult(RESULT_OK, resultIntent)
                finish()
            }
        }
    }
}

@Composable
fun ColorPickerScreen(onColorPicked: (String, Int) -> Unit) {
    val colors = listOf(
        "RED" to 0xFFFF0000.toInt(),
        "ORANGE" to 0xFFFFA500.toInt(),
        "YELLOW" to 0xFFFFFF00.toInt(),
        "GREEN" to 0xFF008000.toInt(),
        "BLUE" to 0xFF0000FF.toInt(),
        "INDIGO" to 0xFF4B0082.toInt(),
        "VIOLET" to 0xFF8F00FF.toInt()
    )

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = stringResource(id = R.string.header_text_picker))
        Spacer(modifier = Modifier.height(16.dp))
        colors.forEach { (name, value) ->
            Button(
                onClick = { onColorPicked(name, value) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                Text(text = stringResource(
                    when (name) {
                        "RED" -> R.string.red
                        "ORANGE" -> R.string.orange
                        "YELLOW" -> R.string.yellow
                        "GREEN" -> R.string.green
                        "BLUE" -> R.string.blue
                        "INDIGO" -> R.string.indigo
                        "VIOLET" -> R.string.violet
                        else -> R.string.red
                    }
                ))
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = stringResource(id = R.string.footer_text_picker))
    }
}