package com.example.covid_19hospitalapp.ui.hospital

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.covid_19hospitalapp.R

class HospitalFragment : Fragment() {

    private lateinit var hospitalViewModel: HospitalViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        hospitalViewModel =
            ViewModelProviders.of(this).get(HospitalViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_hospital, container, false)
        val textView: TextView = root.findViewById(R.id.text_hospital)
        hospitalViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}