package com.example.sharedpreferencesexample

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var name:TextView
    private lateinit var age:TextView
    private lateinit var saveBtn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name=findViewById(R.id.name)
        age=findViewById(R.id.age)
        saveBtn=findViewById(R.id.save)
        saveBtn.setOnClickListener {
            val sharedPreferences:SharedPreferences=getSharedPreferences("preferences", MODE_PRIVATE)
            val editor=sharedPreferences.edit()
            editor.putString("name",name.text.toString())
            editor.putInt("age",age.text.toString().toInt())
            editor.commit()
            intent= Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }
    }
}
