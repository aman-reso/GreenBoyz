package com.example.tripgo.ui.generic

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSearch() {
    var text by rememberSaveable { mutableStateOf("") }
    TextField(value = text, onValueChange = {
        text = it
    }, placeholder = { Text("Search Place") }, modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 4.dp)
        .padding(16.dp),
        shape = RoundedCornerShape(8.dp), colors = TextFieldDefaults.outlinedTextFieldColors(), singleLine = true,
        trailingIcon = {
            if (text.isNotEmpty()) {
                IconButton(onClick = { text = "" }) {
                    Icon(
                        imageVector = Icons.Outlined.Close,
                        contentDescription = null
                    )
                }
            }
        })
}