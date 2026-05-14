package com.example.zadaniebmi

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView

class ShoppingListAdapter(
    private val items: List<ShoppingItem>
) : RecyclerView.Adapter<ShoppingListAdapter.ShoppingItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_shopping, parent, false)
        return ShoppingItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ShoppingItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val checkbox: CheckBox = itemView.findViewById(R.id.checkboxShoppingItem)

        fun bind(item: ShoppingItem) {
            checkbox.setOnCheckedChangeListener(null)
            checkbox.text = itemView.context.getString(
                R.string.shopping_item_format,
                item.name,
                item.amount
            )
            checkbox.isChecked = item.isPurchased
            updateTextStyle(item.isPurchased)

            checkbox.setOnCheckedChangeListener { _, isChecked ->
                item.isPurchased = isChecked
                updateTextStyle(isChecked)
            }
        }

        private fun updateTextStyle(isPurchased: Boolean) {
            checkbox.paintFlags = if (isPurchased) {
                checkbox.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            } else {
                checkbox.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
            }
        }
    }
}
