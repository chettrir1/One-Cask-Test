package com.raju.onecask.presentation.collection_detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.raju.onecask.R
import com.raju.onecask.ui.theme.COLOR_0a1f29
import com.raju.onecask.ui.theme.COLOR_E7E9EA
import com.raju.onecask.ui.theme.OneCaskTheme
import dagger.hilt.android.AndroidEntryPoint

fun start(context: Context) {
    context.startActivity(createDetailsActivityIntent(context))
}

fun createDetailsActivityIntent(context: Context): Intent {
    return Intent(context, CollectionDetailActivity::class.java)
}

@AndroidEntryPoint
class CollectionDetailActivity : ComponentActivity() {
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
                Surface {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                colors = TopAppBarDefaults.smallTopAppBarColors(
                                    containerColor = COLOR_0a1f29,
                                    titleContentColor = COLOR_E7E9EA,
                                ),
                                title = {
                                    Text(
                                        "Genesis Collection",
                                        fontFamily = FontFamily(Font(R.font.lato)),
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.W400,
                                        color = COLOR_E7E9EA,
                                        letterSpacing = TextUnit(0.4F, TextUnitType.Sp),
                                        lineHeight = TextUnit(16F, TextUnitType.Sp),
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                },
                                actions = {
                                    IconButton(onClick = {
                                        onBackPressedDispatcher.onBackPressed()
                                    }) {
                                        Icon(
                                            imageVector = Icons.Rounded.Close,
                                            contentDescription = null,
                                            modifier = Modifier.size(24.dp)
                                        )
                                    }
                                }
                            )
                        },
                    ) { innerPadding ->
                        CollectionDetailScreen(
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}