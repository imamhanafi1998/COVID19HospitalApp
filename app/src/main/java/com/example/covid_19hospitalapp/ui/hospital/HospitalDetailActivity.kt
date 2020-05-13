package com.example.covid_19hospitalapp.ui.hospital

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.covid_19hospitalapp.R

import android.content.Intent
import android.net.Uri
import android.text.Spannable
import android.text.SpannableString
import android.text.style.BackgroundColorSpan
import android.widget.Toast


import kotlinx.android.synthetic.main.activity_hospital_detail.*
import kotlinx.android.synthetic.main.content_hospital_detail.*

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
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

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
        var mapLat = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_REFERRER)
        var mapLong = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_BCC)
        hospitalPhotoDetail.setImageResource(photo)
        hospitalNameDetail.text = name
        hospitalAddressDetail.text = address
//        hospitalContactDetail.text = contact
//        hospitalWebDetail.text = web
//        hospitalMapDetail.text = map

        buttonMap.setOnClickListener {
            openMap(mapLat, mapLong, name)
        }

        buttonCall.setOnClickListener {
            call(contact)
        }

        buttonWeb.setOnClickListener {
            openWeb(web)
        }
    }

    private fun openMap(latitude: String, longitude: String, hospitalName: String) {
        val showMapActivity = Intent(this, HospitalMapsActivity::class.java)
        showMapActivity.putExtra(Intent.ACTION_ASSIST, latitude)
        showMapActivity.putExtra(Intent.ACTION_PICK, longitude)
        showMapActivity.putExtra(Intent.ACTION_APPLICATION_PREFERENCES, hospitalName)

        startActivity(showMapActivity)
    }

    private fun openWeb(url: String) {
        val showWebActivity = Intent(this, HospitalWeb::class.java)
        showWebActivity.putExtra(Intent.ACTION_WEB_SEARCH, url)
        startActivity(showWebActivity)
    }

    private fun call (number: String) {
        val callThis = Intent(Intent.ACTION_DIAL)
        callThis.setData(Uri.parse("tel:"+ number))
        startActivity(callThis)
    }

}
