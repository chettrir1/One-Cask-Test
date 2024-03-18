package com.raju.onecask.presentation.collection_detail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.raju.onecask.ui.theme.COLOR_0B1519
import com.raju.onecask.ui.theme.COLOR_E7E9EA

@Composable
fun GenuineDropDown(
    title: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = COLOR_0B1519,
        ),
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterStart)
            ) {
                Image(
                    painterResource(id = R.drawable.ic_genuine),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    title,
                    fontFamily = FontFamily(Font(R.font.lato)),
                    fontWeight = FontWeight.W700,
                    color = COLOR_E7E9EA,
                    letterSpacing = TextUnit(0.4F, TextUnitType.Sp),
                    lineHeight = TextUnit(21F, TextUnitType.Sp),
                    fontSize = 14.sp,
                )
                Image(
                    painterResource(id = R.drawable.ic_drop_down),
                    contentDescription = null,
                    modifier = Modifier.size(15.dp)
                )

            }
        }
    }

}