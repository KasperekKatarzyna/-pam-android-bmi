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
            val weight = editWeight.text.toString().toDoubleOrNull()
            val height = editHeight.text.toString().toDoubleOrNull()

            if (weight != null && height != null && weight > 0 && height > 0) {
                val bmi = BmiCalculator.calculate(weight, height)

                textResult.text = getString(R.string.bmi_result_format, bmi)
                textInterpretation.text = getString(
                    R.string.bmi_interpretation_format,
                    BmiCalculator.interpret(bmi)
                )
            } else {
                textResult.text = getString(R.string.invalid_bmi_values)
                textInterpretation.text = ""
            }
        }

        buttonBack.setOnClickListener {
            finish()
        }
    }

}
