package com.example.fragmentcommunication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Model:ViewModel() {
    var name= MutableLiveData<String>()
}