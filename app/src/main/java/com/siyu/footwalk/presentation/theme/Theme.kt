package com.siyu.footwalk.presentation.theme


import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val FootWalkColors = lightColorScheme(
    primary = Menthe,
    onPrimary = Ink,
    primaryContainer = Brume,
    onPrimaryContainer = Ink,
    secondary = Verveine,
    onSecondary = Ink,
    secondaryContainer = Limonade,
    onSecondaryContainer = Ink,
    background = Brume,
    onBackground = Ink,
    surface = CardWhite,
    onSurface = Ink,
    surfaceVariant = Brume,
    onSurfaceVariant = InkMuted,
    outline = Menthe,
    error = Color(0xFFB3261E),
)

@Composable
fun FootWalkTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = FootWalkColors,
        typography = FootWalkTypography,
        shapes = FootWalkShapes,
        content = content,
    )
}