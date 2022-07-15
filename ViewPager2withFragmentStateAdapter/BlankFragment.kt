package com.example.viewpager2example

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class BlankFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("fragment created")
        val tv=view.findViewById<TextView>(R.id.tv)
        arguments?.takeIf { it.containsKey("Str") }?.apply {
            //val textView: TextView = view.findViewById(android.R.id.text1)
            tv.text = getString("Str").toString()
        }
    }

}