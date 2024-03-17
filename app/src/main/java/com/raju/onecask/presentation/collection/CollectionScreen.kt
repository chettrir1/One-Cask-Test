package com.raju.onecask.presentation.collection

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.raju.onecask.R
import com.raju.onecask.presentation.collection.component.CollectionItem
import com.raju.onecask.ui.theme.COLOR_E7E9EA

@Composable
fun CollectionScreen(
    onItemClick: () -> Unit,
    viewModel: CollectionViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        ) {
            items(state.collection) { collection ->
                CollectionItem(collection = collection, onItemClick = {
                    onItemClick()
                })
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = COLOR_E7E9EA,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.eb_garamond)),
                fontSize = 22.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center),
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}