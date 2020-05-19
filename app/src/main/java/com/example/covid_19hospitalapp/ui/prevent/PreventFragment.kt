package com.example.covid_19hospitalapp.ui.prevent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.covid_19hospitalapp.R

class PreventFragment : Fragment() {

    private lateinit var preventViewModel: PreventViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        preventViewModel =
            ViewModelProviders.of(this).get(PreventViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_prevent, container, false)
//        val textView: TextView = root.findViewById(R.id.text_prevent)
//        preventViewModel.text.observe(this, Observer {
//            textView.text = it
//        })
        return root
    }
}