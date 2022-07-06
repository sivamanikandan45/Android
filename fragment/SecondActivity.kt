package com.example.fragmentsexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val btn1=findViewById<Button>(R.id.set_frag_one)
        val btn2=findViewById<Button>(R.id.set_frag_two)

        btn1.setOnClickListener {
            replaceFragment(FragmentOne())
        }

        btn2.setOnClickListener {
            replaceFragment(FragmentTwo())
        }
        supportFragmentManager.commit {
            add<BlankFragment>(R.id.second_fragment)
        }

    }

    private fun replaceFragment(fragment: Fragment) {
            supportFragmentManager.commit {
                replace(R.id.second_fragment,fragment)
                setReorderingAllowed(true)
                //addToBackStack(null)
            }
    }
}