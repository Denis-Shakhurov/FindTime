package com.example.findtime.presentation.ui.theme

import androidx.compose.ui.graphics.Color

data class AppColors(
    val primary: Color,
    val onPrimary: Color,
    val secondary: Color
)

val darkColorScheme = AppColors(
    primary = Color(0xFF005cb2),
    onPrimary = Color.White,
    secondary = Color(0xFF00766c)
)

val lightColorScheme = AppColors(
    primary = Color(0xFF1e88e5),
    onPrimary = Color.Black,
    secondary = Color(0xFF26a69a)
)

data class GradientColors(
    val start: Color,
    val end: Color
)

val gradientColors = GradientColors(
    start = Color(0xFF1e88e5),
    end = Color(0xFF005cb2)
)