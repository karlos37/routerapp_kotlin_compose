package ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private fun lightColors(): ColorScheme = androidx.compose.material3.lightColorScheme(
    primary = AppColors.OrangePrimaryLight,
    onPrimary = Color.White,
    background = AppColors.BackgroundLight,
    onBackground = AppColors.OnBackgroundLight,
    surface = AppColors.SurfaceLight,
    onSurface = AppColors.OnBackgroundLight,
    outline = AppColors.OutlineLight
)

private fun darkColors(): ColorScheme = androidx.compose.material3.darkColorScheme(
    primary = AppColors.OrangePrimaryDark,
    onPrimary = AppColors.OnBackgroundDark,
    background = AppColors.BackgroundDark,
    onBackground = AppColors.OnBackgroundDark,
    surface = AppColors.SurfaceDark,
    onSurface = AppColors.OnBackgroundDark,
    outline = AppColors.OutlineDark
)

@Composable
fun AppTheme(
    useDarkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colors = if (useDarkTheme) darkColors() else lightColors()
    MaterialTheme(
        colorScheme = colors,
        typography = AppTypography,
        content = content
    )
}
