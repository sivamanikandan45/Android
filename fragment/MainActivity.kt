package com.example.fragmentsexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.add
import androidx.fragment.app.commit
import kotlinx.coroutines.delay


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nextBtn=findViewById<Button>(R.id.next_button)
        nextBtn.setOnClickListener {
            //Dialog().show(supportFragmentManager,"TAG")
            val intent= Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }


        addFragment()
    }



    fun addFragment(){
        /*val transaction=supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container,BlankFragment())
        transaction.commit()*/

        supportFragmentManager.commit {
            println(this)
            setReorderingAllowed(true)
            /*add(R.id.fragment_container,BlankFragment())*/
            add<BlankFragment>(R.id.fragment_container)
            //addToBackStack(null)
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        println("host activity is saving its state")
        super.onSaveInstanceState(outState)
    }
}
