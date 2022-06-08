package com.example.oppo33w

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {

    private lateinit var recyclerview2: RecyclerView
    private var isLinearLayout = true
    private lateinit var list: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        recyclerview2 = findViewById(R.id.recycler_view_2)
//        var gAdapter: GAdapter = GAdapter(this, getData())
        recyclerview2.adapter = GAdapter(this, getData())

        setLayout()
    }

    private fun getData(): List<String> {
        val intent: Intent = intent
        val key = intent.getStringExtra("key").toString()
        list = intent.getStringArrayListExtra("list")!!.toList()
        return list.filter { it.contains(key) }.sorted()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.item_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.layout -> isLinearLayout = !isLinearLayout
        }
        item.icon = if (isLinearLayout) {
            ContextCompat.getDrawable(this, R.drawable.ic_linear_layout)
        } else {
            ContextCompat.getDrawable(this, R.drawable.ic_grid_layout)
        }
        setLayout()

        return super.onOptionsItemSelected(item)
    }

    private fun setLayout() {
        if (isLinearLayout) {
            recyclerview2.layoutManager = LinearLayoutManager(this)
        } else {
            recyclerview2.layoutManager = GridLayoutManager(this, 3)
        }
    }
}