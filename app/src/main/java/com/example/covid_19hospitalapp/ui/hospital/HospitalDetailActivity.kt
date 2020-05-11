package com.example.covid_19hospitalapp.ui.hospital

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.covid_19hospitalapp.R

import android.content.Intent
import android.net.Uri


import kotlinx.android.synthetic.main.activity_hospital_detail.*
import kotlinx.android.synthetic.main.content_hospital_detail.*
//import kotlinx.android.synthetic.main.content_hospital_detail.*
import kotlinx.android.synthetic.main.hospital_list_item.*

class HospitalDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospital_detail)
        setSupportActionBar(toolbar)

//        sss

//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

//        sss
        var intentThatStartedThisActivity = intent
        if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_COMPONENT_NAME)) {
            putData(intentThatStartedThisActivity)
        }

    }

    private fun putData(intentThatStartedThisActivity : Intent) {
        var photo = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_SPLIT_NAME).toInt()
        var name = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_COMPONENT_NAME)
        var address = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_INSTALLER_PACKAGE_NAME)
        var contact = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_PACKAGE_NAME)
        var web = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_REFERRER_NAME)
        var map = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_REFERRER)
        hospitalPhotoDetail.setImageResource(photo)
        hospitalNameDetail.text = name
        hospitalAddressDetail.text = address
        hospitalContactDetail.text = contact
        hospitalWebDetail.text = web
        hospitalMapDetail.text = map
    }

}
