package com.raju.onecask.presentation.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.raju.onecask.R
import com.raju.onecask.presentation.MainViewModel
import com.raju.onecask.presentation.startMainActivity
import com.raju.onecask.ui.theme.COLOR_0B1519
import com.raju.onecask.ui.theme.COLOR_0a1f29
import com.raju.onecask.ui.theme.COLOR_B8BDBF
import com.raju.onecask.ui.theme.COLOR_D49A00
import com.raju.onecask.ui.theme.COLOR_E7E9EA
import com.raju.onecask.ui.theme.COLOR_FFB901
import com.raju.onecask.ui.theme.OneCaskTheme
import dagger.hilt.android.AndroidEntryPoint

fun startLoginActivity(context: Context) {
    context.startActivity(loginActivityIntent(context))
}

fun loginActivityIntent(context: Context): Intent {
    val intent = Intent(context, LoginActivity::class.java)
    return intent
}

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
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
        setContent {
            OneCaskTheme {
                Surface {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                colors = TopAppBarDefaults.mediumTopAppBarColors(
                                    containerColor = COLOR_0a1f29,
                                    titleContentColor = COLOR_E7E9EA,
                                ),
                                title = {
                                },
                                navigationIcon = {
                                    IconButton(onClick = {
                                        onBackPressedDispatcher.onBackPressed()
                                    }) {
                                        Icon(
                                            painterResource(id = R.drawable.ic_arrow_left),
                                            contentDescription = null
                                        )
                                    }
                                }
                            )
                        },
                    ) { innerPadding ->
                        var showPassword by remember { mutableStateOf(false) }
                        var emailText by remember { mutableStateOf("email@email.com") }
                        var passwordText by remember { mutableStateOf("password") }

                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding)
                        ) {
                            item {
                                Spacer(modifier = Modifier.height(32.dp))
                                Text(
                                    "Sign in",
                                    fontFamily = FontFamily(Font(R.font.eb_garamond)),
                                    fontSize = 32.sp,
                                    fontWeight = FontWeight.W500,
                                    color = COLOR_E7E9EA,
                                    lineHeight = TextUnit(40F, TextUnitType.Sp),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 16.dp)
                                )
                                Spacer(modifier = Modifier.height(32.dp))
                                TextField(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 16.dp),
                                    label = {
                                        Text(
                                            "Email",
                                            fontFamily = FontFamily(Font(R.font.lato)),
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.W400,
                                            color = COLOR_D49A00,
                                            letterSpacing = TextUnit(0.4F, TextUnitType.Sp),
                                            lineHeight = TextUnit(16F, TextUnitType.Sp),
                                        )
                                    },
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                                    value = emailText,
                                    textStyle = TextStyle(
                                        fontFamily = FontFamily(Font(R.font.lato)),
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.W400,
                                        color = COLOR_E7E9EA,
                                        letterSpacing = TextUnit(0.5F, TextUnitType.Sp),
                                        lineHeight = TextUnit(24F, TextUnitType.Sp),
                                    ),
                                    onValueChange = {
                                        emailText = it
                                    },
                                    colors = TextFieldDefaults.textFieldColors(
                                        containerColor = Color.Transparent,
                                        focusedIndicatorColor = COLOR_D49A00,
                                        unfocusedIndicatorColor = COLOR_D49A00
                                    ),
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                                TextField(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 16.dp),
                                    label = {
                                        Text(
                                            "Password",
                                            fontFamily = FontFamily(Font(R.font.lato)),
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.W400,
                                            color = COLOR_D49A00,
                                            letterSpacing = TextUnit(0.4F, TextUnitType.Sp),
                                            lineHeight = TextUnit(16F, TextUnitType.Sp),
                                        )
                                    },
                                    visualTransformation = if (showPassword) {
                                        VisualTransformation.None
                                    } else {
                                        PasswordVisualTransformation()
                                    },
                                    trailingIcon = {
                                        if (showPassword) {
                                            IconButton(onClick = { showPassword = false }) {
                                                Icon(
                                                    painterResource(id = R.drawable.ic_eye),
                                                    contentDescription = null,
                                                    tint = COLOR_D49A00
                                                )
                                            }
                                        } else {
                                            IconButton(onClick = { showPassword = true }) {
                                                Icon(
                                                    painterResource(id = R.drawable.ic_eye),
                                                    contentDescription = null,
                                                    tint = COLOR_D49A00
                                                )
                                            }
                                        }
                                    },
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                                    value = passwordText,
                                    textStyle = TextStyle(
                                        fontFamily = FontFamily(Font(R.font.lato)),
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.W400,
                                        color = COLOR_E7E9EA,
                                        letterSpacing = TextUnit(0.5F, TextUnitType.Sp),
                                        lineHeight = TextUnit(24F, TextUnitType.Sp),
                                    ),
                                    onValueChange = {
                                        passwordText = it
                                    },
                                    colors = TextFieldDefaults.textFieldColors(
                                        containerColor = Color.Transparent,
                                        focusedIndicatorColor = COLOR_D49A00,
                                        unfocusedIndicatorColor = COLOR_D49A00
                                    ),
                                )
                                Spacer(modifier = Modifier.height(32.dp))
                                Button(
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = COLOR_D49A00
                                    ),
                                    shape = RoundedCornerShape(8.dp),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 16.dp),
                                    onClick = {
                                        startMainActivity(activity = this@LoginActivity)
                                    }) {
                                    Text(
                                        "Continue",
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
                                        "Can’t sign in?",
                                        fontFamily = FontFamily(Font(R.font.lato)),
                                        fontWeight = FontWeight.W400,
                                        fontSize = 16.sp,
                                        color = COLOR_B8BDBF,
                                        lineHeight = TextUnit(16F, TextUnitType.Sp),
                                        modifier = Modifier.padding(8.dp)
                                    )
                                    Text(
                                        "Recover password",
                                        fontFamily = FontFamily(Font(R.font.eb_garamond)),
                                        fontWeight = FontWeight.W600,
                                        fontSize = 16.sp,
                                        color = COLOR_FFB901,
                                        lineHeight = TextUnit(16F, TextUnitType.Sp),
                                        modifier = Modifier.padding(8.dp)
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