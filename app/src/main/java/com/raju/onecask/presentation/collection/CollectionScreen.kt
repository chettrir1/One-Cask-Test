package com.raju.onecask.presentation.collection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.raju.onecask.R
import com.raju.onecask.presentation.collection.component.CollectionItem
import com.raju.onecask.ui.theme.COLOR_0B1519
import com.raju.onecask.ui.theme.COLOR_D49A00
import com.raju.onecask.ui.theme.COLOR_E7E9EA
import com.raju.onecask.utils.checkNetworkAvailability

@Composable
fun CollectionScreen(
    onItemClick: (Int) -> Unit,
    viewModel: CollectionViewModel = hiltViewModel()
) {

    val swipeRefreshState = rememberSwipeRefreshState(
        isRefreshing = viewModel.state.value.isRefreshing
    )

    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        var dialogState by remember { mutableStateOf(false) }
        var networkState by remember { mutableStateOf(false) }

        networkState = checkNetworkAvailability(LocalContext.current)

        if (!networkState) {
            dialogState = true
        }

        if (dialogState) {
            AlertDialog(
                modifier = Modifier.fillMaxWidth(),
                onDismissRequest = {
                    dialogState = false
                },
                title = {
                    Text(
                        text = "No Internet!",
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily(Font(R.font.eb_garamond)),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.W700,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                text = {
                    Text(
                        text = "You are not connected to\nthe Internet!",
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily(Font(R.font.eb_garamond)),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                confirmButton = {
                    Button(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = COLOR_D49A00
                        ),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            dialogState = false
                        }) {
                        Text(
                            "Refresh",
                            fontFamily = FontFamily(Font(R.font.eb_garamond)),
                            fontWeight = FontWeight.W600,
                            color = COLOR_0B1519,
                            lineHeight = TextUnit(24F, TextUnitType.Sp),
                            letterSpacing = TextUnit(0.1F, TextUnitType.Sp),
                        )
                    }
                },
            )
        }

        SwipeRefresh(
            state = swipeRefreshState,
            onRefresh = {
                viewModel.onEvent(CollectionEvent.Refresh)
            }
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
            ) {
                items(state.collection) { collection ->
                    CollectionItem(collection = collection, onItemClick = {
                        onItemClick(it.id)
                    })
                }
            }
        }
        if (state.error.isNotBlank()) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "Error Occured!",
                    color = COLOR_E7E9EA,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily(Font(R.font.eb_garamond)),
                    fontSize = 22.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = state.error,
                    color = COLOR_E7E9EA,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily(Font(R.font.eb_garamond)),
                    fontSize = 16.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                )
            }
        }
        if (state.isLoading) {
            CircularProgressIndicator(
                color = COLOR_E7E9EA,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}