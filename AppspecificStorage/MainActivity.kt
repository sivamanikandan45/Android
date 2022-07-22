package com.example.appspecificstorage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val input=findViewById<EditText>(R.id.input)
        val output=findViewById<TextView>(R.id.output)
        val btn=findViewById<Button>(R.id.submit)
        btn.setOnClickListener {
            val msg:String=input.text.toString()
            val file=openFileOutput("outputfile", MODE_PRIVATE)
            file.write(msg.toByteArray())
            //file.close()
            println(file)
            println("App-specific directory in internal storage: $filesDir")
            val list=fileList()
            for(i in 0..list.size-1){
                println("${list[i]}")
            }
            if(Environment.getExternalStorageState()==Environment.MEDIA_MOUNTED){
                println("External storage is available for read and write")
            }else if(Environment.getExternalStorageState()==Environment.MEDIA_MOUNTED_READ_ONLY){
                println("External storage is available for read and write")
            }
        }

        val getBtn=findViewById<Button>(R.id.get)
        getBtn.setOnClickListener {
            //val file=openFileInput("outputfile")
            //output.text=file.useLines()
            val file=openFileInput("outputfile").bufferedReader().useLines { lines ->
                lines.fold("") { some, text ->
                    "$some\n$text"
                }
            }
            output.text=file.lines().toString()
        }

    }
}
