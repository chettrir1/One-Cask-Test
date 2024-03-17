package com.raju.onecask.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.raju.onecask.R
import com.raju.onecask.presentation.bottom_nav.NavItem
import com.raju.onecask.presentation.collection.CollectionScreen
import com.raju.onecask.presentation.collection_detail.start
import com.raju.onecask.presentation.scan.ScanScreen
import com.raju.onecask.presentation.setting.SettingScreen
import com.raju.onecask.presentation.shop.ShopScreen
import com.raju.onecask.ui.theme.COLOR_0a1f29
import com.raju.onecask.ui.theme.COLOR_E7E9EA
import com.raju.onecask.ui.theme.OneCaskTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.color_0a1f29
                )
            ),
            navigationBarStyle = SystemBarStyle.dark(
                ContextCompat.getColor(
                    applicationContext,
                    R.color.color_0a1f29
                )
            )
        )
        super.onCreate(savedInstanceState)
        setContent {
            OneCaskTheme {
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                colors = TopAppBarDefaults.smallTopAppBarColors(
                                    containerColor = COLOR_0a1f29,
                                    titleContentColor = COLOR_E7E9EA,
                                ),
                                title = {
                                    Text(
                                        "My collection",
                                        fontFamily = FontFamily(Font(R.font.eb_garamond)),
                                        fontSize = 32.sp,
                                        fontWeight = FontWeight.W500,
                                        color = COLOR_E7E9EA,
                                        lineHeight = TextUnit(40F, TextUnitType.Sp),
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                },
                                actions = {
                                    Icon(
                                        painterResource(id = R.drawable.ic_bell),
                                        contentDescription = null,
                                        modifier = Modifier.size(24.dp)
                                    )
                                }
                            )
                        },
                        bottomBar = {
                            BottomAppBar { BottomNavigationBar(navController = navController) }
                        },
                    ) { innerPadding ->
                        Box(modifier = Modifier.padding(innerPadding)) {
                            NavHost(navController, startDestination = NavItem.Scan.path) {
                                composable(NavItem.Scan.path) { ScanScreen() }
                                composable(NavItem.Collection.path) {
                                    CollectionScreen(onItemClick = {
                                        start(context = this@MainActivity)
                                    })
                                }
                                composable(NavItem.Shop.path) { ShopScreen() }
                                composable(NavItem.Setting.path) { SettingScreen() }
                            }
                        }
                    }
                }
            }
        }
    }
}

