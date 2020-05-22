package com.example.covid_19hospitalapp.ui.hospital

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

import com.example.covid_19hospitalapp.R

class HospitalMapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    var lat:Double = 0.0
    var long:Double = 0.0
    var name:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospital_maps)

//        custom start
        var intentThatStartedThisActivity = intent
        val latitude = intentThatStartedThisActivity.getStringExtra(Intent.ACTION_ASSIST).toDouble()
        this.lat = latitude
        val longitude = intentThatStartedThisActivity.getStringExtra(Intent.ACTION_PICK).toDouble()
        this.long = longitude
        val nameLocal = intentThatStartedThisActivity.getStringExtra(Intent.ACTION_APPLICATION_PREFERENCES).toString()
        this.name = nameLocal

        if(intentThatStartedThisActivity.hasExtra(Intent.ACTION_ASSIST)) {
            Toast.makeText(this@HospitalMapsActivity, "lat : " + this.lat + ", long : " + this.long, Toast.LENGTH_LONG).show()
        } else {
//            Intent has no ACTION_ASSIST
        }
//        custom end

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val newLoc = LatLng(this.lat, this.long)
        mMap.addMarker(MarkerOptions().position(newLoc).title(this.name))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(newLoc))
        val zoomLevel = 15.0f
        mMap.animateCamera(CameraUpdateFactory.zoomTo(zoomLevel), 2000, null)
    }
}
