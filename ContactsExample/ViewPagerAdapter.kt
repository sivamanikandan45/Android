package com.example.contactsexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter

/*
class ViewPagerAdapter(val viewModel: ContactViewModel,fragmentManager: FragmentManager,lifecycle: Lifecycle):FragmentStateAdapter(fragmentManager, lifecycle) {
    private val list=viewModel.list
    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        val fragment=ContactFragment()
        var pos=viewModel.currentPosition.value
        println("$pos'th fragment is created")
        if (pos != null) {
            viewModel.contact.value=list[pos]
            pos += 1
            viewModel.currentPosition.value=pos
            */
/*val bundle=Bundle()
            bundle.putInt("pos",pos)
            fragment.arguments=bundle*//*

        }
        */
/*viewModel.contact.value=list[viewModel.currentPosition.value
        viewModel.currentPosition.value = viewModel.currentPosition.value?.plus(1)*//*

        return fragment
    }



}*/

class ViewPagerAdapter(val list:List<Contact>) : RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>(){

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val contactName:TextView
        val phn:TextView
        val mail:TextView
        val relationship:TextView
        init {
            contactName=view.findViewById(R.id.fragment_contact_name)
            phn=view.findViewById(R.id.fragment_contact_phone)
            mail=view.findViewById(R.id.fragment_email)
            relationship=view.findViewById(R.id.fragment_relationship)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_contact, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.contactName.text=list[position].name
        holder.phn.text=list[position].phoneNumber
        holder.mail.text=list[position].mail
        holder.relationship.text=list[position].relationship
    }

    override fun getItemCount(): Int {
        return list.size
    }




}