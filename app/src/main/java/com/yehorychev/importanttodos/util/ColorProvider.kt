package com.yehorychev.importanttodos.util

import android.graphics.Color

object ColorProvider {
    private val colors = listOf(
        Color.rgb(205, 180, 219),
        Color.rgb(255, 200, 221),
        Color.rgb(255, 175, 204),
        Color.rgb(189, 224, 254),
        Color.rgb(162, 210, 255),
        Color.rgb(215, 227, 252),
        Color.rgb(182, 204, 254),
        Color.rgb(171, 196, 255),
        Color.rgb(164, 195, 178),
        Color.rgb(204, 227, 222),
        Color.rgb(246, 255, 248),
    )

    fun getColorResourceId(position: Int): Int {
        return colors[position % colors.size]
    }
}