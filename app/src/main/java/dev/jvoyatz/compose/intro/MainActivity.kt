package dev.jvoyatz.compose.intro

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.BlurTransformation
import coil.transform.CircleCropTransformation
import coil.transform.GrayscaleTransformation
import coil.transform.RoundedCornersTransformation
import dev.jvoyatz.compose.intro.repositories.PersonRepository
import dev.jvoyatz.compose.intro.ui.theme.ComposeIntroTheme
import kotlin.text.Typography.section

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeIntroTheme {

                val sections = listOf<String>("a", "b", "c", "d", "e", "f", "g")

                val personRepository = PersonRepository()
                val getAllData = personRepository.getAllData()

                LazyColumn(contentPadding = PaddingValues(
                    all = 12.dp
                ),
                    verticalArrangement = Arrangement.spacedBy(12.dp)) {

                    sections.forEach { section ->
                        stickyHeader {
                            Text(text = "section -> $section",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(Color.LightGray)
                                    .padding(12.dp))
                        }
                        items(10) {

                            Text(text = "item $it fromm the section $section",
                                modifier = Modifier.padding(12.dp)
                            )
                        }
                    }


//                    itemsIndexed(items = getAllData,
//                        key = { index, person ->
//                            person.id
//                        }) {i, p ->
//                        Log.d("tag index", "onCreate: $i")
//                        CustomItem(person = p)
//                    }
                }
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