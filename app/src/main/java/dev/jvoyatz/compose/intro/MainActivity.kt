package dev.jvoyatz.compose.intro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.tooling.preview.Preview
import dev.jvoyatz.compose.intro.ui.theme.ComposeIntroTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeIntroTheme {
                Greeting()
            }
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun Greeting() {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        var name by remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = name,
            onValueChange = {

                if(it.length <= 10) {
                    name = it
                }
            },
            label = { androidx.compose.material3.Text(text = "name") },
            placeholder = { Text(text = "enter your name") },
            maxLines = 1
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview (showBackground = true)
@Composable
fun DefaultPreview(){
    ComposeIntroTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            Greeting()
        }
    }
}