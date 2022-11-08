package com.example.tripgo.ui.generic

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tripgo.ui.theme.buttonRoundCorner
import com.example.tripgo.ui.theme.fontFamily

@Composable
fun CustomActionButton(text: String, onClickCallback: () -> Unit) {
    val state = remember { mutableStateOf(false) }
    Button(onClick = {
        state.value = true
        onClickCallback
    }, shape = RoundedCornerShape(buttonRoundCorner), modifier = Modifier
        .wrapContentWidth()
        .wrapContentHeight()) {
        Row(modifier = Modifier.wrapContentWidth()) {
            Spacer(modifier = Modifier.width(4.dp))
            Icon(
                imageVector = Icons.Default.Place,
                modifier = Modifier
                    .size(18.dp),
                contentDescription = "drawable_icons",
            )
        }
        Text(
            text = text,
            textAlign = TextAlign.Center,
            fontFamily = fontFamily
        )
    }
    if (state.value){
        CustomPopUpWindow()
    }
}

@Preview
@Composable
fun show(){
    CustomActionButton(""){

    }
}