package com.yehorychev.importanttodos.util

import android.graphics.Color

object ColorProvider {
    private val colors = listOf(
        Color.rgb(247, 37, 133),
        Color.rgb(114, 9, 183),
        Color.rgb(58, 12, 163),
        Color.rgb(76, 201, 240),
        Color.rgb(72, 191, 227),
        Color.rgb(86, 207, 225),
        Color.rgb(100, 223, 223),
        Color.rgb(114, 239, 221),
        Color.rgb(128, 255, 219),
    )

    fun getColorResourceId(position: Int): Int {
        return colors[position % colors.size]
    }
}