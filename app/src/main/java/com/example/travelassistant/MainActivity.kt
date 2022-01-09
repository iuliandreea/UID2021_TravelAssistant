package com.example.travelassistant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
<<<<<<< HEAD
import android.view.View
import android.widget.Button
=======
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import com.example.travelassistant.profile_management.activities.SignInActivity
import com.example.travelassistant.profile_management.account.AccountList
>>>>>>> 15ca72cd568388a92f64388f4f137ffedb7f5fae

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
<<<<<<< HEAD
        val accomodationBtn: Button = findViewById(R.id.button)
        accomodationBtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val intent = Intent(applicationContext, NavigationBarActivity::class.java)
                startActivity(intent)
            }

        })
=======

        val exploreButton: Button = findViewById(R.id.exploreButton)
        val signInButton: Button = findViewById(R.id.signInButton)

        if (AccountList.getAccounts().isEmpty()) {
            AccountList.setDefaultAccounts()
        }

        exploreButton.setOnClickListener {
            val myIntent = Intent(this, NavigationBarActivity::class.java)
            myIntent.putExtra("accountId", -1)
            startActivity(myIntent)
        }

        signInButton.setOnClickListener {
            val myIntent = Intent(this, SignInActivity::class.java)
            startActivity(myIntent)
        }

>>>>>>> 15ca72cd568388a92f64388f4f137ffedb7f5fae
    }
}