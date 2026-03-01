package com.example.findtime

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.findtime.presentation.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "FindTime",
    ) {
        App()
    }
}