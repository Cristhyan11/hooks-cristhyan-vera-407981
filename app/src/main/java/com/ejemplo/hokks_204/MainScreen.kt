package com.ejemplo.hokks_204

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainScreen() {
    var fullName by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = fullName,
            onValueChange = { fullName = it },
            label = { Text(text = stringResource(id = R.string.full_name_label), fontSize = 18.sp) },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                if (fullName.isNotEmpty()) {
                    val welcomeIntent = Intent(context, WelcomeActivity::class.java)
                    welcomeIntent.putExtra(MainActivity.FULL_NAME_KEY, fullName)
                    context.startActivity(welcomeIntent)
                } else {
                    Toast.makeText(
                        context,
                        context.getString(R.string.full_name_label),
                        Toast.LENGTH_LONG
                    ).show()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.submit_button_text),
                fontSize = 18.sp
            )
        }
    }
}