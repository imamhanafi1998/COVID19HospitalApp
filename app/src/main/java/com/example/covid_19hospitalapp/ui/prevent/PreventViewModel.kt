package com.example.covid_19hospitalapp.ui.prevent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PreventViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is prevent Fragment"
    }
    val text: LiveData<String> = _text
}