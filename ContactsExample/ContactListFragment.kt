package com.example.contactsexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ContactListFragment : Fragment() {

    private lateinit var manager:LinearLayoutManager
    private lateinit var recyclerView:RecyclerView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel:ContactViewModel by activityViewModels()
        recyclerView=view.findViewById(R.id.contact_recycler)
        recyclerView.setHasFixedSize(true)
        manager= LinearLayoutManager(context)
        recyclerView.layoutManager=manager
        //val list=createList()
        val list=viewModel.list
        val adapter=ListAdapter(list)
        recyclerView.adapter=adapter

        adapter.setOnItemClickListener(object : ListAdapter.ItemClickListener{
            override fun onItemClick(position: Int) {
                //replaceFragment()
                viewModel.contact.value=list[position]
                viewModel.currentPosition.value=position
                //val activity=view.context as AppCompatActivity
                println("$position is clicked in the recycler view")

            }

        })
    }



}
