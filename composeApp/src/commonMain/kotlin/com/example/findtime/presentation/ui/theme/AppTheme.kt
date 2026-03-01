package com.example.findtime.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

val LocalAppColors = staticCompositionLocalOf { lightColorScheme }
val LocalAppStyle = staticCompositionLocalOf { appStyle }
val LocalGradientColors = staticCompositionLocalOf { gradientColors }

@Composable
fun AppTheme(
    themeIsDark: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (themeIsDark) darkColorScheme else lightColorScheme
    val style = appStyle
    val gradient = gradientColors

    CompositionLocalProvider(
        LocalAppColors provides colors,
        LocalAppStyle provides style,
        LocalGradientColors provides gradient,
        content = content
    )
}

object AppThemeProvider {
    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalAppColors.current
    val style: AppStyle
       @Composable
       @ReadOnlyComposable
       get() = LocalAppStyle.current
    val gradientColors: GradientColors
       @Composable
       @ReadOnlyComposable
       get() = LocalGradientColors.current
}