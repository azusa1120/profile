package com.example.profile.ui.screen

import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Abc
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Public
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profile.R
import com.example.profile.ui.theme.ProfileTheme

@Composable
fun EditScreen() {
    ProfileTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MyImage()
            Part("個人情報") {
                Column {
                    Form("氏名", "山田 太郎", KeyboardType.Text)
                    Form("メールアドレス", "sample@example", KeyboardType.Email)
                    Form("自己紹介", "趣味や仕事を書きましょう", KeyboardType.Text)
                }
            }
            Part("設定") {
                Column {
                    Toggle("プッシュ通知", Icons.Default.Notifications)
                    Toggle("公開プロフィール", Icons.Default.Public)
                }
            }
        }
    }
}

@Composable
fun MyImage() {
    // 本当はカメラ起動させたい
    Box {
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = stringResource(id = R.string.image_icon_description),
            modifier = Modifier
                .padding(0.dp, 12.dp, 0.dp, 8.dp)
                .size(160.dp),
            tint = Color(0xFFE2E2ED)
        )
        Box(
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .align(Alignment.BottomEnd)
                .background(
                    color = Color(0xFF4F629F),
                    shape = RoundedCornerShape(8.dp)
                )
        ) {
            Icon(
                imageVector = Icons.Default.CameraAlt,
                contentDescription = stringResource(id = R.string.image_icon_description),
                modifier = Modifier.align(Alignment.Center).padding(8.dp),
                tint = Color(0xFFFFFFFF)
            )
        }
    }
}

@Composable
fun Form(title: String, hint: String, type: KeyboardType) {
    val text = remember{ mutableStateOf("") }
    Column(
        modifier = Modifier.padding(8.dp)
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
fun Toggle(title: String, icon: ImageVector) {
    val checked = remember{ mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth().padding(8.dp, 8.dp)
            .background(color = Color(0xFFE2E2ED),  shape = RoundedCornerShape(4.dp)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.padding(12.dp, 0.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = stringResource(id = R.string.toggle_icon_description),
                modifier = Modifier.padding(0.dp, 16.dp, 12.dp, 16.dp),
                tint = Color(0xFF4F629F)
            )
            Text(text = title)
        }
        Switch(
            checked = checked.value,
            onCheckedChange = { checked.value = it },
            modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 0.dp)
        )
    }
}

@Composable
fun Part(title: String, content: @Composable () -> Unit) {
    Column(
        modifier = Modifier.padding(12.dp)
    ) {
        Text(
            text = title,
            color = Color.Gray,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(8.dp, 0.dp)
        )
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun EditScreenPreview() {
    EditScreen()
}

@Preview(showBackground = true)
@Composable
fun MyImagePreview() {
    MyImage()
}

@Preview(showBackground = true)
@Composable
fun FormPreview() {
    Form("タイトル", "ヒント", KeyboardType.Text)
}

@Preview(showBackground = true)
@Composable
fun TogglePreview() {
    Toggle("タイトル", Icons.Default.Abc)
}