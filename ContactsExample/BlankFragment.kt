package com.example.contactsexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.viewpager2.widget.ViewPager2

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
        val viewpager=view.findViewById<ViewPager2>(R.id.viewpager)
        val viewModel:ContactViewModel by activityViewModels()
        //viewpager.adapter=ViewPagerAdapter(viewModel,parentFragmentManager,lifecycle)
        viewpager.adapter=ViewPagerAdapter(viewModel.list)
        viewModel.currentPosition.value?.let { viewpager.setCurrentItem(it,false) }

    }

}