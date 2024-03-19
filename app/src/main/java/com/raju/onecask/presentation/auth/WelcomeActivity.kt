package com.raju.onecask.presentation.auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.raju.onecask.R
import com.raju.onecask.presentation.MainViewModel
import com.raju.onecask.ui.theme.COLOR_0B1519
import com.raju.onecask.ui.theme.COLOR_122329
import com.raju.onecask.ui.theme.COLOR_B8BDBF
import com.raju.onecask.ui.theme.COLOR_D49A00
import com.raju.onecask.ui.theme.COLOR_E7E9EA
import com.raju.onecask.ui.theme.COLOR_FFB901
import com.raju.onecask.ui.theme.OneCaskTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelcomeActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()


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
        actionBar?.hide()
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.isLoading.value
            }
        }
        setContent {
            OneCaskTheme {
                Surface {
                    Scaffold { innerPadding ->
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding)
                        ) {
                            Card(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .align(Alignment.BottomCenter),
                                colors = CardDefaults.cardColors(
                                    containerColor = COLOR_122329,
                                ),
                            ) {
                                Column(
                                    modifier = Modifier.padding(vertical = 16.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                ) {
                                    Text(
                                        "Welcome!",
                                        fontFamily = FontFamily(Font(R.font.eb_garamond)),
                                        fontWeight = FontWeight.W500,
                                        fontSize = 32.sp,
                                        color = COLOR_E7E9EA,
                                        lineHeight = TextUnit(40F, TextUnitType.Sp),
                                        modifier = Modifier.padding()
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        "Text text text",
                                        fontFamily = FontFamily(Font(R.font.lato)),
                                        fontWeight = FontWeight.W400,
                                        fontSize = 16.sp,
                                        color = COLOR_E7E9EA,
                                        lineHeight = TextUnit(24F, TextUnitType.Sp),
                                        letterSpacing = TextUnit(0.5F, TextUnitType.Sp),
                                        modifier = Modifier.padding(8.dp)
                                    )
                                    Spacer(modifier = Modifier.height(24.dp))
                                    Button(
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = COLOR_D49A00
                                        ),
                                        shape = RoundedCornerShape(8.dp),
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(horizontal = 16.dp),
                                        onClick = {
                                        }) {
                                        Text(
                                            "Scan bottle",
                                            fontFamily = FontFamily(Font(R.font.eb_garamond)),
                                            fontWeight = FontWeight.W600,
                                            fontSize = 16.sp,
                                            color = COLOR_0B1519,
                                            lineHeight = TextUnit(24F, TextUnitType.Sp),
                                            letterSpacing = TextUnit(0.1F, TextUnitType.Sp),
                                            modifier = Modifier.padding(8.dp)
                                        )
                                    }

                                    Spacer(modifier = Modifier.height(32.dp))
                                    Row(
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Text(
                                            "Have an account??",
                                            fontFamily = FontFamily(Font(R.font.lato)),
                                            fontWeight = FontWeight.W400,
                                            fontSize = 16.sp,
                                            color = COLOR_B8BDBF,
                                            lineHeight = TextUnit(16F, TextUnitType.Sp),
                                            modifier = Modifier.padding(8.dp)
                                        )
                                        ClickableText(
                                            text = AnnotatedString("Sign in first"),
                                            onClick = {
                                                startLoginActivity(this@WelcomeActivity)
                                            },
                                            style = TextStyle(
                                                fontFamily = FontFamily(Font(R.font.eb_garamond)),
                                                fontWeight = FontWeight.W600,
                                                fontSize = 16.sp,
                                                color = COLOR_FFB901,
                                                lineHeight = TextUnit(24F, TextUnitType.Sp),
                                            ),

                                            modifier = Modifier.padding(8.dp),
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}