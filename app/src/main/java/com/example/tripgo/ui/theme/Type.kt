package com.example.tripgo.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.tripgo.R

val fontRegular = Font(R.font.mukta_regular,FontWeight.Normal)
val fontMedium = Font(R.font.mutkra_medium,FontWeight.Medium)
val fontSemiBold = Font(R.font.mukta_sb,FontWeight.SemiBold)
val fontBold = Font(R.font.mukta_bold, FontWeight.Bold)
val fontFamily = FontFamily(fontRegular, fontMedium, fontSemiBold, fontBold)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = fontFamily,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.Bold
    )
)
