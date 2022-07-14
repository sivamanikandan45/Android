package com.example.contactsexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val list:List<Contact>):RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    private lateinit var listener: ItemClickListener
    interface ItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: ItemClickListener){
        this.listener=listener
    }

    class ViewHolder(view:View,listener: ItemClickListener):RecyclerView.ViewHolder(view){
        val contactName:TextView
        init {
            contactName=view.findViewById(R.id.contact_name)
            view.setOnClickListener {
                listener.onItemClick(adapterPosition)
                val activity=view.context as AppCompatActivity
                activity.supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace(R.id.container_one,ContactFragment())
                    addToBackStack(null)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_view, parent, false)
        return ViewHolder(view,listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.contactName.text=list[position].name
    }

    override fun getItemCount(): Int {
        return list.size
    }

}