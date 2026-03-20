package com.example.zadaniebmi

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BmiActivity : AppCompatActivity() {

    private lateinit var editWeight: EditText
    private lateinit var editHeight: EditText
    private lateinit var buttonCalculate: Button
    private lateinit var textResult: TextView
    private lateinit var textInterpretation: TextView
    private lateinit var buttonBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)

        editWeight = findViewById(R.id.editWeight)
        editHeight = findViewById(R.id.editHeight)
        buttonCalculate = findViewById(R.id.buttonCalculateBmi)
        textResult = findViewById(R.id.textBmiResult)
        textInterpretation = findViewById(R.id.textBmiInterpretation)
        buttonBack = findViewById(R.id.buttonBackFromBmi)

        buttonCalculate.setOnClickListener {
            val weightText = editWeight.text.toString()
            val heightText = editHeight.text.toString()

            if (weightText.isNotEmpty() && heightText.isNotEmpty()) {
                val weight = weightText.toDouble()
                val height = heightText.toDouble()

                val bmi = weight / Math.pow(height / 100.0, 2.0)

                textResult.text = "Twoje BMI wynosi: %.2f".format(bmi)
                textInterpretation.text = "Interpretacja: ${getBmiInterpretation(bmi)}"
            } else {
                textResult.text = "Uzupełnij wszystkie pola"
                textInterpretation.text = ""
            }
        }

        buttonBack.setOnClickListener {
            finish()
        }
    }

    private fun getBmiInterpretation(bmi: Double): String {
        return when {
            bmi < 18.5 -> "Niedowaga"
            bmi < 25.0 -> "Waga prawidłowa"
            bmi < 30.0 -> "Nadwaga"
            else -> "Otyłość"
        }
    }
}