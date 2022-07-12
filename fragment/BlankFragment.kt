package com.example.fragmentsexample

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class BlankFragment : Fragment() {
    private lateinit var tv:TextView
    private var counter=0
    override fun onAttach(context: Context) {
        println("Attaching..")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        println("Creating..")
        super.onCreate(savedInstanceState)
        if(savedInstanceState!=null){
            counter=savedInstanceState.getInt("count")
            println("Got value as $counter")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        println("View is creating...")
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        println("View created.")
        tv=view.findViewById(R.id.count)
        val btn=view.findViewById<Button>(R.id.increment)
        print("counter is $counter")
        btn.setOnClickListener {
            counter++
            tv.text=counter.toString()
            Dialog().show(childFragmentManager,"TAG")
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        println("View state is restored..")
        super.onViewStateRestored(savedInstanceState)
    }

    override fun onStart() {
        println("Starting..")
        super.onStart()
    }

    override fun onResume() {
        println("Resuming..")
        super.onResume()
    }

    override fun onPause() {
        println("Pausing..")
        super.onPause()
    }

    override fun onStop() {
        println("Stopping..")
        super.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        println("Saving instance state..")
        super.onSaveInstanceState(outState)
        outState.putInt("count",counter)
        println("value is $counter")
    }

    override fun onDestroyView() {
        println("Destroying View..")
        super.onDestroyView()
    }

    override fun onDestroy() {
        println("Destroying fragment..")
        super.onDestroy()
    }

    override fun onDetach() {
        println("Detaching..")
        super.onDetach()
    }

}
