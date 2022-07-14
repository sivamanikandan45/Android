package com.example.viewpager2example

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter

/*
class ViewAdapter(val list: MutableList<String>,fm:FragmentManager,lifecycle: Lifecycle):FragmentStateAdapter(fm,lifecycle) {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        TODO("Not yet implemented")
    }
}*/

class ViewAdapter(var list:List<String>):RecyclerView.Adapter<ViewAdapter.ViewHolder>(){

    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val tv:TextView
        init{
            tv=view.findViewById(R.id.tv)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.fragment_blank,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewAdapter.ViewHolder, position: Int) {
        holder.tv.text=list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }

}
