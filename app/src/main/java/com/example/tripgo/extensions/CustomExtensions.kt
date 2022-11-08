package com.example.tripgo.extensions

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType

fun String.showToastMessage(context: Context?) {
    if (context != null ) {
        Toast.makeText(context, this, Toast.LENGTH_SHORT).show()
    }
}
fun getNumberKeyboardOptions(): KeyboardOptions {
   return KeyboardOptions(keyboardType = KeyboardType.Number)
}