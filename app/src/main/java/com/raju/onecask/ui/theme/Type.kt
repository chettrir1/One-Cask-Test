package com.raju.testtask.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography = Typography(
    titleSmall = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
    ),
    headlineLarge = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp
    ),
    headlineMedium = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp
    ),
    headlineSmall = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    bodySmall = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
)