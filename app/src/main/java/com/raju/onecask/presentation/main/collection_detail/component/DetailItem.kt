package com.raju.onecask.presentation.main.collection_detail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raju.onecask.R
import com.raju.onecask.domain.model.ProductDetailModel
import com.raju.onecask.ui.theme.COLOR_B8BDBF
import com.raju.onecask.ui.theme.COLOR_FFFFFF

@Composable
fun DetailItem(
    model: ProductDetailModel
) {
    Box(
        modifier = Modifier.padding(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = model.title,
                fontFamily = FontFamily(Font(R.font.lato)),
                fontSize = 16.sp,
                fontWeight = FontWeight.W400,
                color = COLOR_FFFFFF,
                letterSpacing = TextUnit(0.5F, TextUnitType.Sp),
                lineHeight = TextUnit(24F, TextUnitType.Sp),
            )
            Text(
                text = model.value,
                fontFamily = FontFamily(Font(R.font.lato)),
                fontSize = 16.sp,
                fontWeight = FontWeight.W400,
                color = COLOR_B8BDBF,
                letterSpacing = TextUnit(0.5F, TextUnitType.Sp),
                lineHeight = TextUnit(24F, TextUnitType.Sp),
            )
        }

    }

}