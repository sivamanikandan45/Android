package com.example.viewpager2example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager=findViewById<ViewPager2>(R.id.viewpager)
        viewPager.adapter=ViewAdapter(mutableListOf("Ohayo gosaimasu","Konnichiwa","Konbanwa"),this)
        //viewPager.adapter=ViewAdapter()
    }
}
