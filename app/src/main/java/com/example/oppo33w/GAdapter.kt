package com.example.oppo33w

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GAdapter(private val context: Context, private val list: List<String> ) :RecyclerView.Adapter<GAdapter.GViewHolder>() {

    class GViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView : TextView = itemView.findViewById(R.id.item_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return GViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: GViewHolder, position: Int) {
        holder.textView.text = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }
}