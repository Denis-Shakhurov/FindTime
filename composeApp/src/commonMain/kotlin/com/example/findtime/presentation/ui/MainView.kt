@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.findtime.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEachIndexed
import com.example.findtime.MR
import com.example.findtime.presentation.ui.theme.AppThemeProvider
import dev.icerock.moko.resources.ImageResource
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource

@Composable
fun MainView(
    actionBarFun: topBarFun = { EmptyComposable() }
) {
    val showAddDialog = remember { mutableStateOf(false) }
    val currentTimezoneStrings = remember { SnapshotStateList<String>() }
    val selectedIndex = remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            actionBarFun(selectedIndex.value)
        },
        floatingActionButton = {
            if (selectedIndex.value == 0) {
                FloatingActionButton(
                    modifier = Modifier
                        .padding(16.dp),
                    shape = FloatingActionButtonDefaults.largeShape,
                    containerColor = AppThemeProvider.colors.secondary,
                    onClick = {
                        showAddDialog.value = true
                    }
                ) {
                    Icon(
                        modifier = Modifier.size(32.dp),
                        painter = painterResource(MR.images.ic_add),
                        contentDescription = "Add Timezone"
                    )
                }
            }
        },
        bottomBar = {
            NavigationBar(
                containerColor = AppThemeProvider.colors.primary,
            ) {
                bottomNavigationItems.fastForEachIndexed { i, bottomNavigationItem ->
                    NavigationBarItem(
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.White,
                            selectedTextColor = Color.White,
                            unselectedIconColor = Color.Black,
                            unselectedTextColor = Color.Black,
                            indicatorColor = AppThemeProvider.colors.primary
                        ),
                        label = {
                            Text(
                                text = bottomNavigationItem.route,
                                style = AppThemeProvider.style.typography.bodyMedium
                            )
                        },
                        icon = {
                            Icon(
                                modifier = Modifier.size(32.dp),
                                painter = painterResource(bottomNavigationItem.icon),
                                contentDescription = bottomNavigationItem.iconContentDescription
                            )
                        },
                        selected = selectedIndex.value == i,
                        onClick = {
                            selectedIndex.value = i
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            // TODO: Replace with Dialog

            when (selectedIndex.value) {
                0 -> TimeZoneScreen(currentTimezoneStrings)
            }
        }
    }
}

sealed class Screen(
    val title: String
) {
    data object TimeZoneScreen : Screen("Timezones")
    data object FindTimeScreen : Screen("Find Time")
}

data class ButtonItem(
    val route: String,
    val icon: ImageResource,
    val iconContentDescription: String
)

val bottomNavigationItems = listOf(
    ButtonItem(
        route = Screen.TimeZoneScreen.title,
        icon = MR.images.ic_language,
        iconContentDescription = "Timezones"
    ),
    ButtonItem(
        route = Screen.FindTimeScreen.title,
        icon = MR.images.ic_place,
        iconContentDescription = "Find Time"
    )
)