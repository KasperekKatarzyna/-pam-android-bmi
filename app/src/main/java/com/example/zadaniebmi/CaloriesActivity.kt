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

        val genderOptions = arrayOf("Mężczyzna", "Kobieta")
        val activityOptions = arrayOf(
            "Niska aktywność",
            "Średnia aktywność",
            "Wysoka aktywność",
            "Bardzo wysoka aktywność"
        )

        spinnerGender.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, genderOptions)
        spinnerActivity.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, activityOptions)

        buttonCalculate.setOnClickListener {
            val ageText = editAge.text.toString()
            val weightText = editWeight.text.toString()
            val heightText = editHeight.text.toString()

            if (ageText.isNotEmpty() && weightText.isNotEmpty() && heightText.isNotEmpty()) {
                val age = ageText.toInt()
                val weight = weightText.toDouble()
                val height = heightText.toDouble()
                val gender = spinnerGender.selectedItem.toString()
                val activity = spinnerActivity.selectedItem.toString()

                val bmr = if (gender == "Mężczyzna") {
                    66.5 + (13.75 * weight) + (5.003 * height) - (6.775 * age)
                } else {
                    655.1 + (9.563 * weight) + (1.850 * height) - (4.676 * age)
                }

                val activityFactor = when (activity) {
                    "Niska aktywność" -> 1.2
                    "Średnia aktywność" -> 1.55
                    "Wysoka aktywność" -> 1.725
                    else -> 1.9
                }

                val calories = bmr * activityFactor
                textCaloriesResult.text = "Dzienne zapotrzebowanie: %.2f kcal".format(calories)
            } else {
                textCaloriesResult.text = "Uzupełnij wszystkie pola"
            }
        }

        buttonBack.setOnClickListener {
            finish()
        }
    }
}