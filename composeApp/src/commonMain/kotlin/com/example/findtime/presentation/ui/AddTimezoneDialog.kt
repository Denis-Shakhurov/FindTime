package com.example.findtime.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.findtime.presentation.ui.theme.AppThemeProvider
import com.example.findtime.utils.TimeZoneHelperImpl

@Composable
fun AddTimezoneDialog(
    onAdd: OnAddType,
    onDismiss: onDismissType
) {
    val selectedTimezones = remember { mutableStateListOf<String>() }
    val allTimezones = remember { TimeZoneHelperImpl().getTimeZoneStrings() }
    var searchQuery by remember { mutableStateOf("") }

    val filteredTimezones = remember(searchQuery) {
        if (searchQuery.isBlank()) {
            allTimezones
        } else {
            allTimezones.filter {
                it.contains(searchQuery, ignoreCase = true)
            }
        }
    }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Column {
                Text("Add Time Zones")
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    label = { Text("Search") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
            }
        },
        text = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 200.dp)
            ) {
                items(filteredTimezones) { timezone ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = timezone,
                            modifier = Modifier.weight(1f)
                        )
                        Checkbox(
                            checked = selectedTimezones.contains(timezone),
                            onCheckedChange = { isChecked ->
                                if (isChecked) {
                                    selectedTimezones.add(timezone)
                                } else {
                                    selectedTimezones.remove(timezone)
                                }
                            },
                            colors = CheckboxDefaults.colors(
                                uncheckedColor = Color.Gray,
                                checkmarkColor = Color.Green
                            )
                        )
                    }
                    HorizontalDivider()
                }
            }
        },
        confirmButton = {
            TextButton(
                onClick = { onAdd(selectedTimezones.toList()) },
                colors = ButtonDefaults.textButtonColors(
                    containerColor = AppThemeProvider.colors.primary,
                    contentColor = AppThemeProvider.colors.onPrimary,
                    disabledContentColor = AppThemeProvider.colors.onPrimary,
                    disabledContainerColor = AppThemeProvider.colors.primary
                ),
                shape = AppThemeProvider.style.shapes.large
            ) {
                Text("Add")
            }
        },
        dismissButton = {
            TextButton(
                onClick = onDismiss,
                colors = ButtonDefaults.textButtonColors(
                    containerColor = AppThemeProvider.colors.primary,
                    contentColor = AppThemeProvider.colors.onPrimary,
                    disabledContentColor = AppThemeProvider.colors.onPrimary,
                    disabledContainerColor = AppThemeProvider.colors.primary
                ),
                shape = AppThemeProvider.style.shapes.large
            ) {
                Text("Cancel")
            }
        }
    )
}