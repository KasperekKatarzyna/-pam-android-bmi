package com.example.zadaniebmi

import kotlin.math.pow

object BmiCalculator {
    fun calculate(weightKg: Double, heightCm: Double): Double {
        require(weightKg > 0) { "Weight must be greater than zero" }
        require(heightCm > 0) { "Height must be greater than zero" }

        return weightKg / (heightCm / 100.0).pow(2.0)
    }

    fun interpret(bmi: Double): String {
        return when {
            bmi < 18.5 -> "Niedowaga"
            bmi < 25.0 -> "Waga prawidłowa"
            bmi < 30.0 -> "Nadwaga"
            else -> "Otyłość"
        }
    }
}
