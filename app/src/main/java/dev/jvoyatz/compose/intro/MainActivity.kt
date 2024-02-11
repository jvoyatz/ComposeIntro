package dev.jvoyatz.compose.intro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.jvoyatz.compose.intro.ui.theme.ComposeIntroTheme
import dev.jvoyatz.compose.intro.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeIntroTheme {
                // A surface container using the 'background' color from the theme
                Column(modifier = Modifier.fillMaxSize()) {
                    Text(text = stringResource(id = R.string.app_name),
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.primary)
                            .padding(16.dp))

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
            CustomText3()
        }
    }
}

@Composable
fun CustomText() {
    Text(text = stringResource(id = R.string.app_name),
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp)
            .width(300.dp),
        color = Color.Cyan,
        fontSize = MaterialTheme.typography.bodyLarge.fontSize,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.End
    )
}

@Composable
fun CustomText2() {
    Text(
        buildAnnotatedString {
            withStyle(style = ParagraphStyle(textAlign = TextAlign.Center)) {
                withStyle(
                    style = SpanStyle(
                        color = Color.DarkGray,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("a")
                }

                append("b")
                append("c")
                append("d")
            }
        }, modifier = Modifier.width(200.dp)
    )
}



@Composable
fun CustomText3() {
    Text(
        text = "hellow world".repeat(30), maxLines = 2, overflow = TextOverflow.Ellipsis
    )
}