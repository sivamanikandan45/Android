package com.example.fragmentsexample

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class Dialog: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //return AlertDialog.Builder(requireContext()).setMessage("Noticd").setPositiveButton("Ok"){}.create()
        return AlertDialog.Builder(requireContext())
            .setMessage("Are you sure?")
            .setPositiveButton("Yes") { _,_ -> }
            .setNegativeButton("No") { _,_ -> dismiss()}
            .create()
    }
}