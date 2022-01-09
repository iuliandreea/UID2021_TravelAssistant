package com.example.travelassistant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import com.example.travelassistant.profile_management.activities.SignInActivity
import com.example.travelassistant.profile_management.account.AccountList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

    }
}