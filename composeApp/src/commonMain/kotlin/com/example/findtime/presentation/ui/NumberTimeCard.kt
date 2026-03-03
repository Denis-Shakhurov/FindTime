package com.example.findtime.presentation.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.findtime.presentation.ui.theme.AppThemeProvider

@Composable
fun NumberTimeCard(
    label: String,
    hour: MutableState<Int>
) {
    Card(
        shape = AppThemeProvider.style.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                text = label,
                style = AppThemeProvider.style.typography.bodySmall.copy(
                    color = Color.Black
                )
            )
            Spacer(modifier = Modifier.size(16.dp))
            NumberPicker(
                hour = hour,
                range = IntRange(0, 23),
                onStateChanged = { hour.value = it }
            )
        }
    }
}