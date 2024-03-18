package com.raju.onecask.presentation

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.raju.onecask.R
import com.raju.onecask.presentation.bottom_nav.NavItem
import com.raju.onecask.ui.theme.COLOR_0B1519
import com.raju.onecask.ui.theme.COLOR_899194
import com.raju.onecask.ui.theme.COLOR_FFFFFF

@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    onItemClick: (Int) -> Unit
) {
    val navItems = listOf(NavItem.Scan, NavItem.Collection, NavItem.Shop, NavItem.Setting)
    var selectedItem by rememberSaveable { mutableIntStateOf(0) }
    NavigationBar(containerColor = COLOR_0B1519) {
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = COLOR_FFFFFF,
                    unselectedIconColor = COLOR_899194,
                    selectedTextColor = COLOR_FFFFFF,
                    unselectedTextColor = COLOR_899194,
                    indicatorColor = COLOR_0B1519,
                ),
                alwaysShowLabel = true,
                icon = {
                    Icon(
                        painterResource(id = item.icon),
                        contentDescription = item.title,
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = {
                    Text(
                        item.title,
                        fontFamily = FontFamily(Font(R.font.lato)),
                        fontSize = 12.sp
                    )
                },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    onItemClick(selectedItem)
                    navController.navigate(item.path.lowercase()) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) { saveState = true }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
