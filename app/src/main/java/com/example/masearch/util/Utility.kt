package com.example.masearch.util

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun addCommas(input: String): String {
    return try {
        val number = input.toLong()
        val formatter = java.text.DecimalFormat("#,###")
        formatter.format(number)
    } catch (e: NumberFormatException) {
        "잘못된 값이 들어왔습니다."
    }
}

fun convertToCombatPower(input: String): String {
    try {
        val number = input.toLong()
        val units = listOf("", "만 ", "억 ", "조 ")

        val sb = StringBuilder()

        var remainingNumber = number
        var unitIndex = 0

        while (remainingNumber > 0) {
            val segment = remainingNumber % 10000
            remainingNumber /= 10000

            if (segment > 0) {
                val segmentStr = segment.toString()
                val formattedSegment = StringBuilder()

                for (i in segmentStr.length - 1 downTo 0) {
                    formattedSegment.insert(0, segmentStr[i])
                }

                if (sb.isNotEmpty()) {
                    sb.insert(0, units[unitIndex])
                }

                sb.insert(0, formattedSegment)
            }

            unitIndex++
        }

        return sb.toString()
    } catch (e: NumberFormatException) {
        return "Invalid Number"
    }
}

fun convertTime(serverTime: String): String {
    var time = serverTime.replace("T", " ").substring(0, serverTime.indexOf("+"))

    // 입력된 문자열을 LocalDateTime으로 파싱
    val dateTime = LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))

    // 새로운 형식으로 포맷
    val formattedDateString = dateTime.format(DateTimeFormatter.ofPattern("yyyy년 M월 d일 a hh:mm까지 사용가능"))


    return formattedDateString
}

inline fun Modifier.noRippleClickable(crossinline onClick: ()->Unit): Modifier = composed {
    clickable(indication = null,
        interactionSource = remember { MutableInteractionSource() }) {
        onClick()
    }
}
