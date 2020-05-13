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
import kotlinx.android.synthetic.main.activity_hospital_detail.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.app_bar_main.toolbar

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
//            Toast.makeText(this@HospitalMapsActivity, "Intent bug, harap kembali ke halaman sebelumnya terlebih dahulu", Toast.LENGTH_LONG).show()
        }

//        custom end

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val loc = LatLng(-34.0, 151.0)
        val newLoc = LatLng(this.lat, this.long)
        mMap.addMarker(MarkerOptions().position(newLoc).title(this.name))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(newLoc))
        val zoomLevel : Float = 15.0f
        mMap.animateCamera(CameraUpdateFactory.zoomTo(zoomLevel), 2000, null)
    }
}
