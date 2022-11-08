package com.example.tripgo.ui.generic

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup

@Composable
fun CustomPopUpWindow() {
    Box {
        val popupWidth = 200.dp
        val popupHeight = 100.dp
        val cornerSize = 16.dp

        Popup(alignment = Alignment.Center) {
            // Draw a rectangle shape with rounded corners inside the popup
            Column(
                Modifier
                    .size(popupWidth, popupHeight)
                    .background(shape = RoundedCornerShape(8.dp), color = White)
            ) {
                Text(text = "Aman", modifier = Modifier.padding(8.dp))
                Text(text = "Aman", modifier = Modifier.padding(8.dp))
                Text(text = "Aman", modifier = Modifier.padding(8.dp))

            }
        }
    }
}