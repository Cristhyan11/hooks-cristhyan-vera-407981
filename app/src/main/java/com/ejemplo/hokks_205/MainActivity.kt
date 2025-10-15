package com.ejemplo.activityresults

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {

    companion object {
        const val RAINBOW_COLOR_NAME = "RAINBOW_COLOR_NAME"
        const val RAINBOW_COLOR = "RAINBOW_COLOR"
        const val TRANSPARENT = 0x00FFFFFF
    }

    // Propiedades de estado
    private var rainbowColor by mutableStateOf(Color(TRANSPARENT))
    private var colorName by mutableStateOf("")
    private var colorMessage by mutableStateOf("")

    // Launcher para recibir el resultado
    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { activityResult ->
            val data = activityResult.data
            rainbowColor = Color(
                data?.getIntExtra(RAINBOW_COLOR, TRANSPARENT) ?: TRANSPARENT
            )
            colorName = data?.getStringExtra(RAINBOW_COLOR_NAME) ?: ""
            colorMessage = getString(R.string.color_chosen_message, colorName)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainScreen(
                backgroundColor = rainbowColor,
                colorMessage = colorMessage,
                context = this,
                startForResult = startForResult
            )
        }
    }
}