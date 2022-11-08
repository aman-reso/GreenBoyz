package com.example.tripgo.ui.generic

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomSingleText(text: String) {
    Text(text = text, modifier = Modifier.clickable { }.padding(0.dp).padding(16.dp).fillMaxWidth())
}