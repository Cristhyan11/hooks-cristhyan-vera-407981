package com.ejemplo.hooks_202

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.ejemplo.hooks_202.ui.theme.Hooks_202Theme
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    private var randomNumber: Int = 0

    companion object {
        private const val RANDOM_NUMBER = "RANDOM_NUMBER"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        if (savedInstanceState != null) {
            randomNumber = savedInstanceState.getInt(RANDOM_NUMBER, 0)
        }

        setContent {
            Hooks_202Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RandomNumberScreen(
                        savedRandom = randomNumber,
                        onRandomChanged = { randomNumber = it },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(RANDOM_NUMBER, randomNumber)
    }
}

@Composable
fun RandomNumberScreen(
    savedRandom: Int,
    onRandomChanged: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    var randomNumber by remember { mutableStateOf(savedRandom) }

    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth(),
    ) {
        Text(text = "Número aleatorio: $randomNumber", fontSize = 18.sp)
        Button(
            onClick = {
                val newRandom = generateRandomNumber()
                randomNumber = newRandom
                onRandomChanged(newRandom)
            }
        ) {
            Text(text = "Generar número aleatorio", fontSize = 18.sp)
        }
    }
}

private fun generateRandomNumber(): Int {
    return Random.nextInt(0, 1000)
}

@Preview(showBackground = true)
@Composable
fun RandomNumberScreenPreview() {
    Hooks_202Theme {
        RandomNumberScreen(savedRandom = 0, onRandomChanged = {})
    }
}