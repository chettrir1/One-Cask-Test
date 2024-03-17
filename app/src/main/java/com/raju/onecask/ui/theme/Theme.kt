package com.raju.onecask.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import com.raju.testtask.ui.theme.Typography

private val DarkColorScheme = darkColorScheme(
    primary = COLOR_0B1519,
    background = COLOR_0a1f29,
    onBackground = COLOR_0a1f29,
    onPrimary = COLOR_0B1519
)

private val LightColorScheme = lightColorScheme(
    primary = COLOR_0B1519,
    background = COLOR_0a1f29,
    onBackground = COLOR_0a1f29,
    onPrimary = COLOR_0B1519
)

@Composable
fun OneCaskTheme(
    darkTheme: Boolean = true, content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}