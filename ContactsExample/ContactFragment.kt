package com.example.contactsexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels

class ContactFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel:ContactViewModel by activityViewModels()
        val nameTv=view.findViewById<TextView>(R.id.fragment_contact_name)
        val phnTv=view.findViewById<TextView>(R.id.fragment_contact_phone)
        viewModel.contact.observe(viewLifecycleOwner) {
            nameTv.text = it.name
            phnTv.text = it.phoneNumber
        }
    }

}