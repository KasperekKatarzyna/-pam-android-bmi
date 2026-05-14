package com.example.zadaniebmi

import org.junit.Assert.*
import org.junit.Test

class BmiCalculatorTest {
    @Test
    fun calculate_returnsExpectedBmiForValidWeightAndHeight() {
        val bmi = BmiCalculator.calculate(weightKg = 70.0, heightCm = 175.0)

        assertEquals(22.86, bmi, 0.01)
    }

    @Test
    fun interpret_returnsNormalWeightForBmiInHealthyRange() {
        val interpretation = BmiCalculator.interpret(22.86)

        assertEquals("Waga prawidłowa", interpretation)
    }

    @Test(expected = IllegalArgumentException::class)
    fun calculate_throwsExceptionForZeroHeight() {
        BmiCalculator.calculate(weightKg = 70.0, heightCm = 0.0)
    }
}
