package com.example.covid_19hospitalapp.ui.hospital

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.webkit.JsResult
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.covid_19hospitalapp.R
import kotlinx.android.synthetic.main.hospital_web.*

class HospitalWeb : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.hospital_web)
        val webView = findViewById<WebView>(R.id.hospitalWeb)

        actionBar?.setDisplayHomeAsUpEnabled(false)

        var intentThatStartedThisActivity = intent

        if(intentThatStartedThisActivity.hasExtra(Intent.ACTION_WEB_SEARCH)) {
            var hospitalWeb = intentThatStartedThisActivity.getStringExtra(Intent.ACTION_WEB_SEARCH)
            webView.settings.javaScriptEnabled = true
            webView.webViewClient = object  : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    if (view != null) {
                        view.loadUrl("javascript:alert('Load selesai')")
                    }
                }
            }
            webView.webChromeClient = object : WebChromeClient() {
                override fun onJsAlert(
                    view: WebView?,
                    url: String?,
                    message: String?,
                    result: JsResult?
                ): Boolean {
                    Toast.makeText(this@HospitalWeb, message, Toast.LENGTH_LONG).show()
                    if (result != null) {
                        result.confirm()
                    }
                    return true
                }
            }
            webView.loadUrl(hospitalWeb)
        } else {
//            Intent has no ACTION_WEB_SEARCH
        }

    }
}