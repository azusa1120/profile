package com.example.profile.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.profile.Nav
import com.example.profile.ui.theme.ProfileTheme

@Composable
fun MainScreen(navController: NavController) {
    ProfileTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "プロフィールを作成しましょう",
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Button(onClick = { navController.navigate(Nav.Edit.name) }) {
                Text(text = "プロフィールを作成する")
            }
        }
    }
}