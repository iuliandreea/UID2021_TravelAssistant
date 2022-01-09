package com.example.travelassistant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatDelegate
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.travelassistant.profile_management.activities.SignInActivity
import com.example.travelassistant.profile_management.account.AccountList
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val exploreButton: Button = findViewById(R.id.exploreButton)
        val signInButton: Button = findViewById(R.id.signInButton)

        val layout: ConstraintLayout = findViewById(R.id.constraintLayout)
        layout.visibility = View.VISIBLE

        val progress: ProgressBar = findViewById(R.id.progressBar)
        progress.visibility = View.INVISIBLE

        if (AccountList.getAccounts().isEmpty()) {
            AccountList.setDefaultAccounts()
        }

        signInButton.setOnClickListener {
            val myIntent = Intent(this, SignInActivity::class.java)
            startActivity(myIntent)
        }

        exploreButton.setOnClickListener {
            layout.visibility = View.INVISIBLE
            progress.visibility = View.VISIBLE

            var progressTimer = java.util.Timer("Setting Up", false).schedule(1500) {
                android.os.Handler(mainLooper).post {
                    val myIntent = Intent(this@MainActivity, NavigationBarActivity::class.java)
                    myIntent.putExtra("accountId", -1)
                    startActivity(myIntent)
                }
            }
        }
    }
}