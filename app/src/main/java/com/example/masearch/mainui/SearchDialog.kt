package com.example.masearch.mainui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.masearch.ui.theme.AbilityBackgroundColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchDialog(
    onDismiss: () -> Unit,
    onSearch: (String) -> Unit
) {
    var searchText by remember { mutableStateOf("") }

    // Back 버튼을 누르면 다이얼로그가 닫히도록 설정
    BackHandler(onBack = onDismiss)

    Dialog(
        onDismissRequest = { onDismiss() }
    ) {
        Surface(shape = RoundedCornerShape(5.dp), color = AbilityBackgroundColor) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TextField(
                    value = searchText,
                    shape = RoundedCornerShape(90.dp),
                    onValueChange = { searchText = it },
                    placeholder = {
                        Text(
                            "아이디를 입력해주세요",
                            style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false)),
                            fontSize = 20.sp,
                            fontFamily = FontFamily(
                                Font(
                                    R.font.notosans_bold,
                                    FontWeight.Normal,
                                    FontStyle.Normal
                                )
                            ),
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    textStyle = TextStyle(
                        platformStyle = PlatformTextStyle(includeFontPadding = false),
                        fontSize = 20.sp,
                        fontFamily = FontFamily(
                            Font(
                                R.font.notosans_bold,
                                FontWeight.Normal,
                                FontStyle.Normal
                            )
                        ),
                    ),
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        // 검색 버튼을 누를 때 입력값을 콜백으로 전달하고 다이얼로그를 닫음
                        onSearch(searchText)
                        onDismiss()
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text(text = "검색하기")
                }
            }
        }

    }
}