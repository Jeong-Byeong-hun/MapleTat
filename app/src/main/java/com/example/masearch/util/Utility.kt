package com.example.masearch.util

import android.util.Log

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
        Log.d("TAG", "convertToCombatPower: " + sb.toString())
        return sb.toString()
    } catch (e: NumberFormatException) {
        return "Invalid Number"
    }
}