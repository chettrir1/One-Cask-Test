package com.raju.onecask.presentation.main.collection_detail.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raju.onecask.R
import com.raju.onecask.domain.model.ProductTastingNoteListModel
import com.raju.onecask.ui.theme.COLOR_111c20
import com.raju.onecask.ui.theme.COLOR_E7E9EA

@Composable
fun TestingNotesItem(model: ProductTastingNoteListModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = COLOR_111c20,
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
        ) {
            Text(
                text = model.notesTitle,
                fontFamily = FontFamily(Font(R.font.eb_garamond)),
                fontSize = 22.sp,
                fontWeight = FontWeight.W500,
                color = COLOR_E7E9EA,
                lineHeight = TextUnit(28F, TextUnitType.Sp),
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = model.notesDescription,
                fontFamily = FontFamily(Font(R.font.lato)),
                fontSize = 16.sp,
                fontWeight = FontWeight.W400,
                color = COLOR_E7E9EA,
                letterSpacing = TextUnit(0.5F, TextUnitType.Sp),
                lineHeight = TextUnit(24F, TextUnitType.Sp),
            )
        }

    }

}