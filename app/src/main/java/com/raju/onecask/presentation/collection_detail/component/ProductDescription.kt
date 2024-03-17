package com.raju.onecask.presentation.collection_detail.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raju.onecask.R
import com.raju.onecask.ui.theme.COLOR_0B1519
import com.raju.onecask.ui.theme.COLOR_111c20
import com.raju.onecask.ui.theme.COLOR_122329
import com.raju.onecask.ui.theme.COLOR_899194
import com.raju.onecask.ui.theme.COLOR_D49A00
import com.raju.onecask.ui.theme.COLOR_E7E9EA
import com.raju.onecask.ui.theme.COLOR_FFFFFF

@Composable
fun ProductDescription() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = COLOR_122329)
            .padding(16.dp)
    ) {

        Column {
            Text(
                "Bottle 135/184",
                fontFamily = FontFamily(Font(R.font.lato)),
                fontSize = 12.sp,
                fontWeight = FontWeight.W400,
                color = COLOR_E7E9EA,
                letterSpacing = TextUnit(0.4F, TextUnitType.Sp),
                lineHeight = TextUnit(16F, TextUnitType.Sp),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(color = COLOR_E7E9EA)) {
                        append("Talisker ")
                    }
                    withStyle(style = SpanStyle(color = COLOR_D49A00)) {
                        append("18 Year old\n")
                    }
                    withStyle(style = SpanStyle(color = COLOR_E7E9EA)) {
                        append("#2504")
                    }
                },
                fontWeight = FontWeight.W500,
                fontFamily = FontFamily(
                    Font(R.font.eb_garamond)
                ),
                fontSize = 32.sp,
                lineHeight = TextUnit(40F, TextUnitType.Sp),
                letterSpacing = TextUnit(0.4F, TextUnitType.Sp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Tabs()

        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Tabs() {

    val tabItems = listOf(
        TabItem(title = "Details"),
        TabItem(title = "Tasting notes"),
        TabItem(title = "History"),
    )

    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }
    val pagerState = rememberPagerState {
        tabItems.size
    }
    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress) {
            selectedTabIndex = pagerState.currentPage
        }
    }
    TabRow(
        selectedTabIndex = selectedTabIndex,
        indicator = { tabPositions ->
            Box(
                modifier = Modifier
                    .tabIndicatorOffset(tabPositions[selectedTabIndex])
                    .height(0.dp)
            )
        },
        containerColor = COLOR_111c20
    ) {
        tabItems.forEachIndexed { index, item ->
            val selected = selectedTabIndex == index

            Tab(
                selected = (index == selectedTabIndex),
                modifier = if (selected) Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(
                        COLOR_D49A00
                    )
                    .padding(8.dp)
                else Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(
                        COLOR_111c20
                    )
                    .padding(8.dp),
                onClick = {
                    selectedTabIndex = index
                }
            ) {
                Text(
                    text = item.title,
                    fontFamily = FontFamily(Font(R.font.lato)),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W400,
                    color = if (selected) COLOR_0B1519 else COLOR_899194,
                    letterSpacing = TextUnit(0.4F, TextUnitType.Sp),
                    lineHeight = TextUnit(16F, TextUnitType.Sp),
                )
            }
        }

    }
    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxWidth()
    ) { index ->
        Text(
            text = tabItems[index].title,
            fontSize = 32.sp,
            color = COLOR_FFFFFF
        )
    }
}

data class TabItem(
    val title: String
)

