package com.example.profile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.profile.ui.theme.ProfileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainNav()
        }
    }
}

@Composable
fun MainNav() {
    val navController = rememberNavController()

    ProfileTheme {
        NavHost(navController = navController, startDestination = "top") {
            composable(route = "top") {
                // TODO: TOP画面のコンポーザブル関数を呼び出す
            }
            composable(route = "edit") {
                // TODO: 編集画面のコンポーザブル関数を呼び出す
            }
        }
    }
}