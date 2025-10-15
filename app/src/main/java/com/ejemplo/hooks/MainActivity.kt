package com.ejemplo.hooks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ejemplo.hooks.ui.theme.HooksTheme
import android.util.Log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HooksTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        Log.d(TAG, "onCreate")
        //Log.d(TAG, "onRestart")
        //Log.d(TAG, "onStart")
        //Log.d(TAG, "onRestoreInstanceState")
        //Log.d(TAG, "onResume")
        //Log.d(TAG, "onPause")
        //Log.d(TAG, "onStop")
        //Log.d(TAG, "onSaveInstanceState")
        //Log.d(TAG, "onDestroy")

    }
    companion object {
        private const val TAG = "MainActivity"
    }
}

// Add this block!
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}