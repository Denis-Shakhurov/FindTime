package com.example.findtime.presentation.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.findtime.MR
import com.example.findtime.presentation.ui.theme.AppThemeProvider
import dev.icerock.moko.resources.compose.painterResource

@Composable
fun NumberPicker(
    hour: MutableState<Int>,
    range: IntRange,
    onStateChanged: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .wrapContentSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = {
                if (hour.value > range.first) {
                    hour.value -= 1
                    onStateChanged(hour.value)
                }
            },
            modifier = Modifier.size(32.dp)
        ) {
            Icon(
                painter = painterResource(MR.images.ic_arrow_down), // замените на вашу иконку
                contentDescription = "Decrease",
                tint = if (hour.value > range.first) Color.Black else Color.Gray
            )
        }

        Text(
            text = hour.value.toString().padStart(2, '0'),
            style = AppThemeProvider.style.typography.bodyLarge.copy(
                color = Color.Black,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .width(40.dp)
                .padding(horizontal = 8.dp)
        )

        IconButton(
            onClick = {
                if (hour.value < range.last) {
                    hour.value += 1
                    onStateChanged(hour.value)
                }
            },
            modifier = Modifier.size(32.dp)
        ) {
            Icon(
                painter = painterResource(MR.images.ic_arrow_up), // замените на вашу иконку
                contentDescription = "Increase",
                tint = if (hour.value < range.last) Color.Black else Color.Gray
            )
        }
    }
}