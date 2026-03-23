package com.example.profile.ui.screen

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profile.ui.theme.ProfileTheme

@Composable
fun EditScreen() {
    ProfileTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Part("個人情報") {
                Column {
                    Form("氏名", "山田 太郎", KeyboardType.Text)
                    Form("メールアドレス", "sample@example", KeyboardType.Email)
                    Form("自己紹介", "趣味や仕事を書きましょう", KeyboardType.Text)
                }
            }
        }
    }
}

@Composable
fun Form(title: String, hint: String, type: KeyboardType) {
    val text = remember{ mutableStateOf("") }
    Column(
        modifier = Modifier.padding(10.dp, 5.dp)
    ) {
        Text(text = title, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleSmall)
        TextField(
            value = text.value,
            onValueChange = { text.value = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = hint) },
            keyboardOptions = KeyboardOptions(keyboardType = type),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}

@Composable
fun Part(title: String, content: @Composable () -> Unit) {
    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        Text(
            text = title,
            color = Color.Gray,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.labelSmall
        )
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun EditScreenPreview() {
    EditScreen()
}