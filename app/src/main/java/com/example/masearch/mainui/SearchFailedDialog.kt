package com.example.masearch.mainui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.masearch.R


@Composable
fun SearchFailedDialog(errorData: String, onDismiss: () -> Unit) {
    BackHandler(onBack = onDismiss)

    Dialog(
        onDismissRequest = { onDismiss() }
    ) {
        Surface(shape = RoundedCornerShape(5.dp), color = Color.White) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    errorData,
                    style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
                    fontSize = 16.sp,
                    fontFamily = FontFamily(
                        Font(
                            R.font.notosans_bold,
                            FontWeight.Normal,
                            FontStyle.Normal
                        )
                    ),
                )
            }
        }
    }

}