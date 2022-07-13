package com.example.fragmentcommunication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class FragmentOne : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel:Model by activityViewModels()
        val button=view.findViewById<Button>(R.id.submit)
        button.setOnClickListener {
            viewModel.name.value=view.findViewById<EditText>(R.id.name_editText).text.toString()
            /*println("CLicked")
            viewModel.name.observe(viewLifecycleOwner, Observer {
                // Perform an action with the latest item data
                //val mut=MutableLiveData(view.findViewById<EditText>(R.id.name_editText).text.toString())
                viewModel.name.value=view.findViewById<EditText>(R.id.name_editText).text.toString()
                println("${viewModel.name}")
            })*/
            //viewModel.name=view.findViewById<EditText>(R.id.name_editText).text.toString()
        }
    }

}