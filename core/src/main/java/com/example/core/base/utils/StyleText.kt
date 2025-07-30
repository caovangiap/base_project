package com.example.core.base.utils

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Định nghĩa Local style
val LocalTextStyle = compositionLocalOf {
    TextStyle.Default // Giá trị mặc định
}
// Style cho Title và Subtitle
val TitleStyle = TextStyle(
    fontSize = 20.sp,
    fontWeight = FontWeight.Normal,
    color = Color.Black
)
val SubtitleStyle = TextStyle(
    fontSize = 16.sp,
    fontWeight = FontWeight.Normal,
    color = Color.Black
)