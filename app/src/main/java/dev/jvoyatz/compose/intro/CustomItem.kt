package dev.jvoyatz.compose.intro

import android.content.res.Resources.Theme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.jvoyatz.compose.intro.models.Person
import dev.jvoyatz.compose.intro.ui.theme.Typography

@Composable
fun CustomItem(person: Person) {
    Row(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "${person.age}",
            color = Color.Black,
            fontSize = Typography.headlineLarge.fontSize,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = person.firstName,
            color = Color.Black,
            fontSize = Typography.headlineMedium.fontSize,
            fontWeight = FontWeight.Normal
        )
        Text(
            text = person.lastName,
            color = Color.Black,
            fontSize = Typography.headlineSmall.fontSize,
            fontWeight = FontWeight.Normal
        )
    }
}


@Composable
@Preview
fun CustomItemPreview() {
    CustomItem(
        person = Person(
            id = 0,
            firstName = "John",
            lastName = "Doe",
            age = 20
        )
    )
}