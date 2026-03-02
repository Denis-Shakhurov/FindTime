package com.example.findtime.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxDefaults
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.math.absoluteValue

@Composable
fun AnimatedSwipeDismiss(
    item: String,
    background: @Composable (Float) -> Unit,
    content: composeFun,
    onDismiss: (String) -> Unit
) {
    val dismissState = rememberSwipeToDismissBoxState(
        positionalThreshold = SwipeToDismissBoxDefaults.positionalThreshold
    )

    LaunchedEffect(dismissState.currentValue) {
        when (dismissState.currentValue) {
            SwipeToDismissBoxValue.EndToStart -> {
                onDismiss(item)
                dismissState.snapTo(SwipeToDismissBoxValue.Settled)
            }
            SwipeToDismissBoxValue.StartToEnd -> {
                dismissState.snapTo(SwipeToDismissBoxValue.Settled)
            }
            else -> {}
        }
    }

    SwipeToDismissBox(
        state = dismissState,
        backgroundContent = {
            val progress = when (dismissState.currentValue) {
                SwipeToDismissBoxValue.EndToStart ->
                    dismissState.progress.absoluteValue
                SwipeToDismissBoxValue.StartToEnd ->
                    dismissState.progress.absoluteValue
                else -> 0f
            }

            val alpha = progress
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        when (dismissState.currentValue) {
                            SwipeToDismissBoxValue.EndToStart -> Color.Red
                            SwipeToDismissBoxValue.StartToEnd -> Color.Green
                            else -> Color.Transparent
                        }.copy(alpha = alpha)
                    )
                    .padding(start = 20.dp, end = 20.dp)
            ) {
                background(progress)
            }
        },
        content = {
            content()
        }
    )
}