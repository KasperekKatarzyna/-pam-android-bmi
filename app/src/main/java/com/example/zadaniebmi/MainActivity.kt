package com.example.zadaniebmi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var buttonBmi: Button
    private lateinit var buttonCalories: Button
    private lateinit var buttonShoppingList: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonBmi = findViewById(R.id.buttonBmi)
        buttonCalories = findViewById(R.id.buttonCalories)
        buttonShoppingList = findViewById(R.id.buttonShoppingList)

        buttonBmi.setOnClickListener {
            val intent = Intent(this, BmiActivity::class.java)
            startActivity(intent)
        }

        buttonCalories.setOnClickListener {
            val intent = Intent(this, CaloriesActivity::class.java)
            startActivity(intent)
        }

        buttonShoppingList.setOnClickListener {
            val intent = Intent(this, ShoppingListActivity::class.java)
            startActivity(intent)
        }
    }
}
