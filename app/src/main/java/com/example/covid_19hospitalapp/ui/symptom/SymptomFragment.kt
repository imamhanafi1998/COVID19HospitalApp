package com.example.covid_19hospitalapp.ui.symptom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.covid_19hospitalapp.R

class SymptomFragment : Fragment() {

    private lateinit var symptomViewModel: SymptomViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        symptomViewModel =
            ViewModelProviders.of(this).get(SymptomViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_symptom, container, false)
        val textView: TextView = root.findViewById(R.id.text_symptom)
        symptomViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}