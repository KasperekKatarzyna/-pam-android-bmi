package com.example.zadaniebmi

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import java.util.Locale
import kotlin.math.ceil
import kotlin.math.floor

class BmiChartView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val entries = listOf(
        BmiHistoryEntry("Sty", 25.8),
        BmiHistoryEntry("Lut", 25.4),
        BmiHistoryEntry("Mar", 24.9),
        BmiHistoryEntry("Kwi", 24.5),
        BmiHistoryEntry("Maj", 24.1),
        BmiHistoryEntry("Cze", 23.7)
    )

    private val axisPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.rgb(110, 110, 110)
        strokeWidth = dp(1.5f)
        style = Paint.Style.STROKE
    }

    private val gridPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.rgb(226, 226, 226)
        strokeWidth = dp(1f)
        style = Paint.Style.STROKE
    }

    private val linePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.rgb(0, 121, 107)
        strokeWidth = dp(3f)
        style = Paint.Style.STROKE
        strokeCap = Paint.Cap.ROUND
        strokeJoin = Paint.Join.ROUND
    }

    private val pointPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.rgb(0, 121, 107)
        style = Paint.Style.FILL
    }

    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.rgb(64, 64, 64)
        textAlign = Paint.Align.CENTER
        textSize = sp(12f)
    }

    private val valuePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.rgb(64, 64, 64)
        textAlign = Paint.Align.RIGHT
        textSize = sp(11f)
    }

    private val linePath = Path()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if (entries.isEmpty()) {
            return
        }

        val left = dp(42f)
        val top = dp(18f)
        val right = width - dp(18f)
        val bottom = height - dp(34f)
        val chartWidth = right - left
        val chartHeight = bottom - top
        val minValue = floor(entries.minOf { it.value } - 0.5)
        val maxValue = ceil(entries.maxOf { it.value } + 0.5)
        val valueRange = maxValue - minValue

        for (step in 0..4) {
            val y = bottom - chartHeight * step / 4f
            val value = minValue + valueRange * step / 4.0
            canvas.drawLine(left, y, right, y, gridPaint)
            canvas.drawText(
                String.format(Locale.getDefault(), "%.1f", value),
                left - dp(8f),
                y + dp(4f),
                valuePaint
            )
        }

        canvas.drawLine(left, top, left, bottom, axisPaint)
        canvas.drawLine(left, bottom, right, bottom, axisPaint)

        linePath.reset()
        entries.forEachIndexed { index, entry ->
            val x = left + chartWidth * index / (entries.lastIndex.coerceAtLeast(1)).toFloat()
            val y = bottom - ((entry.value - minValue) / valueRange).toFloat() * chartHeight

            if (index == 0) {
                linePath.moveTo(x, y)
            } else {
                linePath.lineTo(x, y)
            }
        }
        canvas.drawPath(linePath, linePaint)

        entries.forEachIndexed { index, entry ->
            val x = left + chartWidth * index / (entries.lastIndex.coerceAtLeast(1)).toFloat()
            val y = bottom - ((entry.value - minValue) / valueRange).toFloat() * chartHeight

            canvas.drawCircle(x, y, dp(4.5f), pointPaint)
            canvas.drawText(entry.label, x, bottom + dp(20f), textPaint)
        }
    }

    private fun dp(value: Float): Float = value * resources.displayMetrics.density

    private fun sp(value: Float): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, value, resources.displayMetrics)
    }
}
