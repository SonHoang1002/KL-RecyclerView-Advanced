package com.example.oppo33w

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recycler: RecyclerView
    private lateinit var btn1 : Button

    // Keeps track of which LayoutManager is in use for the [RecyclerView]
    private var isLinearLayoutManager = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler = findViewById(R.id.recycler_view)
        btn1 = findViewById(R.id.btn1)



        val ga = GAdapter(this, getList())
        recycler.adapter = ga
        setLayout()

        btn1.setOnClickListener {
            var intent : Intent = Intent(this, MainActivity2::class.java)
            intent.putStringArrayListExtra("list", ArrayList(getList()))
            intent.putExtra("key",findViewById<TextView>(R.id.message).text.toString())
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.item_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.layout -> isLinearLayoutManager = !isLinearLayoutManager
        }
        setLayout()
        item.icon = if(isLinearLayoutManager){
            ContextCompat.getDrawable(this,R.drawable.ic_linear_layout)
        }else{
            ContextCompat.getDrawable(this,R.drawable.ic_grid_layout)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setLayout() {
        if (isLinearLayoutManager) {
            recycler.layoutManager = LinearLayoutManager(this)
        } else {
            recycler.layoutManager = GridLayoutManager(this, 4)
        }
    }
    private fun getList(): List<String> {
        val list = mutableListOf<String>()
        for (i in 'A'..'x') {
            list.add("$i")
        }
//        list.add("?")
//        list.add(":")
//        list.add("@")
//        list.add("!")
//        list.add("#")
//        list.add("$")

        return list.toList()
    }
}