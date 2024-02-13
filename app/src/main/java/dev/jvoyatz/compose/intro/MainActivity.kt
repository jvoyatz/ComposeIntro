package dev.jvoyatz.compose.intro

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.jvoyatz.compose.intro.ui.theme.ComposeIntroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeIntroTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    GoogleButton(
                        text = "Sign in with Google",
                        loadingText = "Signing in",
                        onClicked = {
                            Log.d("main activitiy", "onClicked: clicked")
                        }
                    )
                }
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun DefaultPreview(){
    ComposeIntroTheme {
        Column(modifier = Modifier.fillMaxSize()) {

        }
    }
}