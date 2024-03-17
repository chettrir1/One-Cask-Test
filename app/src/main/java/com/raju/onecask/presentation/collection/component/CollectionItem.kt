package com.raju.onecask.presentation.collection.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raju.onecask.R
import com.raju.onecask.domain.model.CollectionModel
import com.raju.onecask.ui.theme.COLOR_122329
import com.raju.onecask.ui.theme.COLOR_D7D5D1
import com.raju.onecask.ui.theme.COLOR_E7E9EA

@Composable
fun CollectionItem(
    collection: CollectionModel,
    onItemClick: (CollectionModel) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = COLOR_122329,
        ),
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onItemClick(collection)
                }
                .padding(20.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_bottle),
                contentDescription = collection?.collectionName,
                modifier = Modifier
                    .height(height = 190.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Box {
                Text(
                    text = collection.collectionName,
                    fontFamily = FontFamily(Font(R.font.eb_garamond)),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.W500,
                    color = COLOR_E7E9EA,
                    lineHeight = TextUnit(28F, TextUnitType.Sp),
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = collection.bottles,
                fontFamily = FontFamily(Font(R.font.lato)),
                fontSize = 12.sp,
                fontWeight = FontWeight.W400,
                letterSpacing = TextUnit(0.4F, TextUnitType.Sp),
                color = COLOR_D7D5D1,
                lineHeight = TextUnit(16F, TextUnitType.Sp),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

