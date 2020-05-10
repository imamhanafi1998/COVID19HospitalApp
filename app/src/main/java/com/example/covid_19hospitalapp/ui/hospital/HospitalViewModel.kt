package com.example.covid_19hospitalapp.ui.hospital

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HospitalViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is hospital Fragment"
    }
    val text: LiveData<String> = _text
}