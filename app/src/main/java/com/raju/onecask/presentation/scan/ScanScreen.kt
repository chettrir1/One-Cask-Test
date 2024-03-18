package com.raju.onecask.presentation.scan

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.raju.onecask.R
import com.raju.onecask.ui.theme.COLOR_E7E9EA

/**
 * Composable function that represents the home screen of the application.
 */
@Composable
fun ScanScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = "No Data Available!",
            fontFamily = FontFamily(Font(R.font.eb_garamond)),
            fontSize = 22.sp,
            fontWeight = FontWeight.W500,
            color = COLOR_E7E9EA,
        )
    }
}