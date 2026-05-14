package com.example.zadaniebmi

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CaloriesActivity : AppCompatActivity() {

    private lateinit var editAge: EditText
    private lateinit var editWeight: EditText
    private lateinit var editHeight: EditText
    private lateinit var spinnerGender: Spinner
    private lateinit var spinnerActivity: Spinner
    private lateinit var buttonCalculate: Button
    private lateinit var textCaloriesResult: TextView
    private lateinit var buttonBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calories)

        editAge = findViewById(R.id.editAge)
        editWeight = findViewById(R.id.editCaloriesWeight)
        editHeight = findViewById(R.id.editCaloriesHeight)
        spinnerGender = findViewById(R.id.spinnerGender)
        spinnerActivity = findViewById(R.id.spinnerActivity)
        buttonCalculate = findViewById(R.id.buttonCalculateCalories)
        textCaloriesResult = findViewById(R.id.textCaloriesResult)
        buttonBack = findViewById(R.id.buttonBackFromCalories)

        val genderOptions = resources.getStringArray(R.array.gender_options)
        val activityOptions = resources.getStringArray(R.array.activity_options)

        spinnerGender.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, genderOptions)
        spinnerActivity.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, activityOptions)

        buttonCalculate.setOnClickListener {
            val age = editAge.text.toString().toIntOrNull()
            val weight = editWeight.text.toString().toDoubleOrNull()
            val height = editHeight.text.toString().toDoubleOrNull()

            if (age != null && weight != null && height != null && age > 0 && weight > 0 && height > 0) {
                val bmr = if (spinnerGender.selectedItemPosition == 0) {
                    66.5 + (13.75 * weight) + (5.003 * height) - (6.775 * age)
                } else {
                    655.1 + (9.563 * weight) + (1.850 * height) - (4.676 * age)
                }

                val activityFactors = doubleArrayOf(1.2, 1.55, 1.725, 1.9)
                val activityFactor = activityFactors[spinnerActivity.selectedItemPosition]

                val calories = bmr * activityFactor
                textCaloriesResult.text = getString(R.string.calories_result_format, calories)
            } else {
                textCaloriesResult.text = getString(R.string.invalid_calorie_values)
            }
        }

        buttonBack.setOnClickListener {
            finish()
        }
    }
}
