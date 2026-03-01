@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.findtime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.findtime.presentation.ui.MainView
import com.example.findtime.presentation.ui.theme.AppThemeProvider
import dev.icerock.moko.resources.compose.stringResource
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        Napier.base(DebugAntilog())
        setContent {
            MainView {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = AppThemeProvider.colors.primary
                    ),
                    title = {
                        when (it) {
                            0 -> Text(text = stringResource(MR.strings.world_clocks))
                            else -> Text(text = stringResource(MR.strings.findmeeting))
                        }
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    MainView()
}