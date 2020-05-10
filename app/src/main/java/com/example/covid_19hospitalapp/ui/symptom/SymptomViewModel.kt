package com.example.covid_19hospitalapp.ui.symptom

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SymptomViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is symptom Fragment"
    }
    val text: LiveData<String> = _text
}