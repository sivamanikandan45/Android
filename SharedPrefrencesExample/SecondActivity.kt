package com.example.sharedpreferencesexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    private lateinit var name:TextView
    private lateinit var age:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val preferences=getSharedPreferences("preferences", MODE_PRIVATE)
        val userName=preferences.getString("name","default")
        val userAge=preferences.getInt("age",0)
        name=findViewById(R.id.name_label)
        age=findViewById(R.id.age_label)

        name.text=userName
        age.text=userAge.toString()

    }
}