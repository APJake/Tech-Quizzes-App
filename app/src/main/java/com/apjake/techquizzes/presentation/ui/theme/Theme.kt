package com.apjake.techquizzes.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = PurpleVariant,
    primaryVariant = Purple,
    secondary = PinkVariant,
    background = PurpleMediumDark,
    onBackground = PurpleWhite,
    onPrimary = PurpleWhite,
    surface = PurpleDark,
    onSurface = PurpleWhite,
)

private val LightColorPalette = lightColors(
    primary = Purple,
    primaryVariant = PurpleVariant,
    secondary = Pink,
    background = PurpleMediumWhite,
    onBackground = PurpleMediumDark,
    onPrimary = PurpleDark,
    surface = PurpleWhite,
    onSurface = PurpleMediumDark
)


@Composable
fun TechQuizzesTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}