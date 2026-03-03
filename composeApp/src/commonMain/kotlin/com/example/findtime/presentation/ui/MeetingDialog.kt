package com.example.findtime.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.findtime.presentation.ui.theme.AppThemeProvider

@Composable
fun MeetingDialog(
    hours: SnapshotStateList<Int>,
    onDismiss: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismiss,
    ) {
        Card(
            shape = AppThemeProvider.style.shapes.large,
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .wrapContentHeight()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {
                Text(
                    text = "Доступное время для встречи",
                    style = AppThemeProvider.style.typography.titleMedium.copy(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                if (hours.isEmpty()) {
                    Text(
                        text = "Нет доступного времени",
                        style = AppThemeProvider.style.typography.bodyMedium.copy(
                            color = Color.Gray
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 24.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                } else {
                    Text(
                        text = hours.toList().joinToString(", "),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                    )
                }
                Spacer(modifier = Modifier.size(24.dp))
                Button(
                    onClick = onDismiss,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = AppThemeProvider.style.shapes.medium,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AppThemeProvider.colors.primary
                    )
                ) {
                    Text(
                        text = "ОК",
                        style = AppThemeProvider.style.typography.bodyMedium.copy(
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }
        }
    }
}