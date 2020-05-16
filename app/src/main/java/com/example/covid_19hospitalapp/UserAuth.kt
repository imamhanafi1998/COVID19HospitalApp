package com.example.covid_19hospitalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.user_container.*
import kotlinx.android.synthetic.main.user_registration.*

class UserAuth : AppCompatActivity() {

    lateinit var handler: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_container)

        handler = DatabaseHelper(this)

        showHome()

        save.setOnClickListener {
            if (name.text.toString() == "" || password_register.text.toString() == "") {
                Toast.makeText(this, "Harap isi semua field", Toast.LENGTH_SHORT).show()
            } else {
                if (handler.insertUserData(name.text.toString(), password_register.text.toString())) {
                    Toast.makeText(this, "Registrasi Sukses", Toast.LENGTH_SHORT).show()
                    name.text.clear()
                    password_register.text.clear()
                } else {
                    Toast.makeText(this, "Username tidak tersedia!!!", Toast.LENGTH_SHORT).show()
                    password_register.text.clear()
                }
            }
        }

        login_button.setOnClickListener {
            if (login_name.text.toString() == "" || login_password.text.toString() == "") {
                Toast.makeText(this, "Harap isi semua field", Toast.LENGTH_SHORT).show()
            } else {
                if (handler.userPresent(login_name.text.toString(), login_password.text.toString())) {
                    Toast.makeText(this, "Login Sukses", Toast.LENGTH_SHORT).show()
                    login_name.text.clear()
                    login_password.text.clear()
                    val intentMain = Intent(this, MainActivity::class.java)
                    startActivity(intentMain)
                } else {
                    Toast.makeText(this, "Username atau Password salah!!!", Toast.LENGTH_SHORT).show()
                    login_password.text.clear()
                }
            }
        }

        fltr.setOnClickListener {
            login_name.text.clear()
            login_password.text.clear()
            showRegistration()
        }

        frtl.setOnClickListener {
            name.text.clear()
            password_register.text.clear()
            showLogin()
        }
    }



    private fun showRegistration() {
        registration_layout.visibility = View.VISIBLE
        login_layout.visibility = View.GONE
        user_c.visibility = View.GONE
    }

    private fun showLogin() {
        registration_layout.visibility = View.GONE
        login_layout.visibility = View.VISIBLE
        user_c.visibility = View.GONE
    }

    private fun showHome() {
        registration_layout.visibility = View.GONE
        login_layout.visibility = View.VISIBLE
        user_c.visibility = View.GONE
    }
}
