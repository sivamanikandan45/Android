package com.example.contactsexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContactViewModel:ViewModel() {
    var contact=MutableLiveData<Contact>()
}