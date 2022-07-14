package com.example.contactsexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment()
    }

    private fun addFragment() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            //add<ContactFragment>(R.id.container_one)
            add<ContactListFragment>(R.id.container_one)
        }
    }

    fun replaceFragment(){
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.container_one,ContactFragment())
        }
    }
}
