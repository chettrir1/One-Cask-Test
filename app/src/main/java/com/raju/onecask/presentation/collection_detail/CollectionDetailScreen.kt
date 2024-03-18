@file:OptIn(ExperimentalLayoutApi::class)

package com.raju.onecask.presentation.collection_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.raju.onecask.R
import com.raju.onecask.presentation.collection_detail.component.GenuineDropDown
import com.raju.onecask.presentation.collection_detail.component.ProductDescription

@Composable
fun CollectionDetailScreen(
    modifier: Modifier,
    viewModel: CollectionDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = modifier) {
        state.product.let { product ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                item {
                    GenuineDropDown(title = "Genuine Bottle (Unopened)")
                    Spacer(modifier = Modifier.height(24.dp))
                    Image(
                        painterResource(id = R.drawable.img_bottle),
                        contentDescription = null,
                        modifier = Modifier
                            .height(400.dp)
                            .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    ProductDescription(product)
                }
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
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