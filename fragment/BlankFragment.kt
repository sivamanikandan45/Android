package com.example.fragmentsexample

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class BlankFragment : Fragment() {
    override fun onAttach(context: Context) {
        println("Attaching..")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        println("Creating..")
        super.onCreate(savedInstanceState)
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
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        println("View state restored")
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
