package com.ejemplo.hokks_203


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import com.ejemplo.hooks_203.ui.theme.Hooks_203Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Hooks_203Theme {
                WelcomeForm()
            }
        }
    }
}

@Composable
fun WelcomeForm() {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var showWelcome by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // First Name TextField
        OutlinedTextField(
            value = firstName,
            onValueChange = {
                firstName = it
                showWelcome = false
            },
            label = { Text("First name:") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
        )

        // Last Name TextField
        OutlinedTextField(
            value = lastName,
            onValueChange = {
                lastName = it
                showWelcome = false
            },
            label = { Text("Last name:") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )

        // Enter Button
        Button(
            onClick = { showWelcome = true },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6C47A6))
        ) {
            Text("Enter", color = Color.White, fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(24.dp))

        if (showWelcome) {
            Text(
                text = "Welcome to the app $firstName $lastName!",
                fontSize = 18.sp
            )
        }
    }
}