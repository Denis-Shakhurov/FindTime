package com.example.findtime.presentation.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.findtime.presentation.ui.theme.AppThemeProvider

@Composable
fun TimeCard(
    timezone: String,
    hours: Double,
    time: String,
    date: String
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .height(120.dp)
            .background(Color.White)
            .padding(8.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            shape = AppThemeProvider.style.shapes.medium,
            border = BorderStroke(1.dp, Color.Gray)
        ) {
            Box(
                modifier = Modifier
                    .background(color = Color.White)
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Column(
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = timezone,
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                color = Color.Black
                            )
                        )
                        Spacer(modifier = Modifier.weight(1.0f))
                        Row {
                            Text(
                                text = hours.toString(),
                                style = TextStyle(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp,
                                    color = Color.Black
                                )
                            )
                            Text(
                                text = " hours from local",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    color = Color.Black
                                )
                            )
                        }
                    }
                    Spacer(modifier = Modifier.weight(1.0f))
                    Column(
                        horizontalAlignment = Alignment.End
                    ) {
                        Text(
                            text = time,
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp,
                                color = Color.Black
                            )
                        )
                        Spacer(modifier = Modifier.weight(1.0f))
                        Text(
                            text = date,
                            style = TextStyle(
                                fontSize = 12.sp,
                                color = Color.Black
                            )
                        )
                    }
                }
            }
        }
    }
}