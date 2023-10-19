package com.plcoding.meditationuiyoutube.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.composefirst.R
import com.example.composefirst.ui.theme.theme.AquaBlue
import com.example.composefirst.ui.theme.theme.TextWhite

val gothicA1 = FontFamily(
    listOf(
        Font(R.font.gothica1_regular, FontWeight.Normal),
        Font(R.font.gothica1_medium, FontWeight.Medium),
        Font(R.font.gothica1_semibold, FontWeight.SemiBold),
        Font(R.font.gothica1_bold, FontWeight.Bold),
        Font(R.font.gothica1_black, FontWeight.Black),
    )
)

// Set of Material typography styles to start with
val Typography = Typography(
    displaySmall = TextStyle(
        color = AquaBlue,
        fontFamily = gothicA1,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    displayLarge = TextStyle(
        color = TextWhite,
        fontFamily = gothicA1,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),
    displayMedium = TextStyle(
        color = TextWhite,
        fontFamily = gothicA1,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    )
)