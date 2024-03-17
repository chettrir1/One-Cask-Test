package com.raju.onecask.presentation.collection_detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.core.content.ContextCompat
import com.raju.onecask.R
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
                    CollectionDetailScreen(
                        onBackClick = {
                            onBackPressedDispatcher.onBackPressed()
                        }
                    )
                }
            }
        }
    }
}