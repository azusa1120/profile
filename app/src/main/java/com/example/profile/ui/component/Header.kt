package com.example.profile.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.profile.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header(title: String, onBackClick: (() -> Unit)? = null) {
    CenterAlignedTopAppBar(
        title = { Text( text = title, fontWeight = FontWeight.Bold) },
        modifier = Modifier.fillMaxWidth(),
        navigationIcon = {
            if (onBackClick != null) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.Default.ArrowBackIosNew,
                        contentDescription = stringResource(id = R.string.back_icon_description)
                    )
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun HeaderPreview() {
    Header("タイトル")
}