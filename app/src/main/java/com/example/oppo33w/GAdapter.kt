package com.example.oppo33w

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GAdapter(private val context: Context, private val list: List<String> ) :RecyclerView.Adapter<GAdapter.GViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return GViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: GViewHolder, position: Int) {
        holder.textView.text = list[position]
        holder.textView.setOnClickListener {
            val str = list[position]
            val intent : Intent = Intent(context,MainActivity2::class.java)
            intent.putExtra("key",str)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
    class GViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView : TextView = itemView.findViewById(R.id.item_title)

    }
}