package com.example.hw6_m3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(
    private val context: Context,
    private val items: List<Item>,
    private val listener: (Item) -> Unit
): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.cityText)
        private val imageView: ImageView = itemView.findViewById(R.id.cityImage)

        fun bind(item: Item, listener: (Item) -> Unit) {
            textView.text = item.text
            if (item.imageResId != 0) {
                imageView.setImageResource(item.imageResId)
                imageView.visibility = View.VISIBLE
            } else {
                imageView.visibility = View.GONE
            }

            itemView.setOnClickListener { listener(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_city, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item, listener)
    }
}