package com.raju.onecask.presentation.main.collection_detail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
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
import com.raju.onecask.domain.model.ProductLabelModel
import com.raju.onecask.ui.theme.COLOR_0B1519
import com.raju.onecask.ui.theme.COLOR_D49A00
import com.raju.onecask.ui.theme.COLOR_E7E9EA
import com.raju.onecask.ui.theme.COLOR_FFFFFF

@Composable
fun HistoryItem(model: ProductLabelModel) {
    Box(
        modifier = Modifier.padding(horizontal = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .height(intrinsicSize = IntrinsicSize.Max) // this make height of all cards to the tallest card.

        ) {
            Box {
                Divider(
                    color = COLOR_D49A00,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp)
                        .align(Alignment.Center)
                )
                Icon(
                    painterResource(id = R.drawable.ic_circle),
                    contentDescription = null,
                    tint = COLOR_FFFFFF,
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.TopStart)
                )

                Icon(
                    painterResource(id = R.drawable.ic_accents),
                    contentDescription = null,
                    tint = COLOR_D49A00,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(6f)) {
                Text(
                    "Label",
                    fontFamily = FontFamily(Font(R.font.lato)),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W400,
                    color = COLOR_FFFFFF,
                    lineHeight = TextUnit(16F, TextUnitType.Sp),
                    letterSpacing = TextUnit(0.4F, TextUnitType.Sp),
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    model.title,
                    fontFamily = FontFamily(Font(R.font.eb_garamond)),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.W500,
                    color = COLOR_E7E9EA,
                    lineHeight = TextUnit(28F, TextUnitType.Sp),
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    model.description,
                    fontFamily = FontFamily(Font(R.font.lato)),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W400,
                    color = COLOR_FFFFFF,
                    lineHeight = TextUnit(16F, TextUnitType.Sp),
                    letterSpacing = TextUnit(0.4F, TextUnitType.Sp),
                )
                Spacer(modifier = Modifier.height(8.dp))

                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = COLOR_0B1519,
                    ),
                ) {
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Icon(
                                painterResource(id = R.drawable.ic_paperclip),
                                contentDescription = null,
                                tint = COLOR_FFFFFF,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                "Attachments",
                                fontFamily = FontFamily(Font(R.font.lato)),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.W400,
                                color = COLOR_FFFFFF,
                                lineHeight = TextUnit(16F, TextUnitType.Sp),
                                letterSpacing = TextUnit(0.4F, TextUnitType.Sp),
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Image(
                                painterResource(id = R.drawable.img_attachment),
                                contentDescription = null,
                                modifier = Modifier.size(64.dp)
                            )
                            Image(
                                painterResource(id = R.drawable.img_attachment),
                                contentDescription = null,
                                modifier = Modifier.size(64.dp)
                            )
                            Image(
                                painterResource(id = R.drawable.img_attachment),
                                contentDescription = null,
                                modifier = Modifier.size(64.dp)
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }

    }

}