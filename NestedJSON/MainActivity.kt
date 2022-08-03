package com.example.nestedjson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.Group
import androidx.core.net.toUri
import kotlinx.coroutines.*
import org.json.JSONObject
import org.json.JSONTokener
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var bundle:Bundle= Bundle()
        val btn=findViewById<Button>(R.id.submit)
        btn.setOnClickListener {
            GlobalScope.launch {
                val job=GlobalScope.launch {
                    bundle=getInfo()
                }
                job.join()
            }
            /*val intent= Intent(this,SecondActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)*/

        }
    }

    private suspend fun getInfo():Bundle {
        val bundle=Bundle()
        withContext(Dispatchers.IO){
            val url="https://randomuser.me/api/"
            val connection= URL(url).openConnection() as HttpURLConnection
            val reader=BufferedReader(InputStreamReader(connection.inputStream))
            var response=""
            var line=reader.readLine()
            while(line!=null){
                response+=line
                line=reader.readLine()
            }

            if(response.isNotEmpty()){
                println("Processing..!!")
                //val jsonObject = JSONTokener(response).nextValue() as JSONObject
                val jsonObject = JSONTokener(response).nextValue() as JSONObject

                val jsonArray = jsonObject.getJSONArray("results")

                for(i in 0 until jsonArray.length()){
                    val gender=jsonArray.getJSONObject(i).getString("gender")
                    val name=jsonArray.getJSONObject(i).getJSONObject("name")
                    val title=name.getString("title")
                    val first=name.getString("first")
                    val last=name.getString("last")
                    println(title+"\t"+first+"\t"+last)



                    val location=jsonArray.getJSONObject(i).getJSONObject("location")
                    val street=location.getJSONObject("street")
                    val number=street.getString("number")
                    val streetName=street.getString("name")

                    val pic=jsonArray.getJSONObject(i).getJSONObject("picture")
                    val imageUrl=pic.getString("thumbnail")

                    val city=location.getString("city")
                    val state=location.getString("state")
                    val country=location.getString("country")
                    val postCode=location.getString("postcode")

                    val address="${number.toString()},\t$streetName,\t$city,\t$state,\t$country,\t$postCode"

                    val email=jsonArray.getJSONObject(i).getString("email")
                    val phone=jsonArray.getJSONObject(i).getString("phone")

                    val dob=jsonArray.getJSONObject(i).getJSONObject("dob")
                    val date=dob.getString("date")
                    val age=jsonArray.getJSONObject(i).getString("gender")


                    println(number+"\t"+streetName)

                    /*bundle.putString("title",title)
                    bundle.putString("first",first)
                    bundle.putString("last",last)*/

                    withContext(Dispatchers.Main){
                        val titleTextView=findViewById<TextView>(R.id.title)
                        titleTextView.text=title
                        val firstName=findViewById<TextView>(R.id.first_name)
                        firstName.text=first
                        val lastName=findViewById<TextView>(R.id.last_name)
                        lastName.text=last
                        val addressTV=findViewById<TextView>(R.id.address)
                        addressTV.text=address
                        val genderTextView=findViewById<TextView>(R.id.gender)
                        genderTextView.text=gender
                        val emailTextView=findViewById<TextView>(R.id.email)
                        val dobTextView=findViewById<TextView>(R.id.dob)
                        val ageTv=findViewById<TextView>(R.id.age)
                        val phn=findViewById<TextView>(R.id.phone)

                        val imgView=findViewById<ImageView>(R.id.profile_pic)
                        imgView.setImageURI(imageUrl.toUri())

                        val grp=findViewById<Group>(R.id.group)
                        grp.visibility= View.VISIBLE

                        emailTextView.text=email
                        dobTextView.text=date
                        ageTv.text=age
                        phn.text=phone



                        //val address=findViewById<>()

                    }
                }

                //val nameObject=JSONTokener(name).nextValue() as JSONObject

            }

        }
        return bundle
    }
}
