package com.example.zadaniebmi

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ShoppingListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_list)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerShoppingList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ShoppingListAdapter(createShoppingItems())

        findViewById<Button>(R.id.buttonBackFromShopping).setOnClickListener {
            finish()
        }
    }

    private fun createShoppingItems(): List<ShoppingItem> {
        return listOf(
            ShoppingItem(getString(R.string.shopping_chicken), getString(R.string.amount_chicken)),
            ShoppingItem(getString(R.string.shopping_salad_mix), getString(R.string.amount_salad_mix)),
            ShoppingItem(getString(R.string.shopping_tomato), getString(R.string.amount_tomato)),
            ShoppingItem(getString(R.string.shopping_cucumber), getString(R.string.amount_cucumber)),
            ShoppingItem(getString(R.string.shopping_pepper), getString(R.string.amount_pepper)),
            ShoppingItem(getString(R.string.shopping_yogurt), getString(R.string.amount_yogurt)),
            ShoppingItem(getString(R.string.shopping_olive_oil), getString(R.string.amount_olive_oil)),
            ShoppingItem(getString(R.string.shopping_bread), getString(R.string.amount_bread))
        )
    }
}
